package com.example.dy

import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import com.elvishew.xlog.BuildConfig
import com.elvishew.xlog.LogConfiguration
import com.elvishew.xlog.XLog
import com.elvishew.xlog.printer.AndroidPrinter
import com.elvishew.xlog.printer.file.FilePrinter
import com.elvishew.xlog.printer.file.backup.NeverBackupStrategy
import com.elvishew.xlog.printer.file.clean.FileLastModifiedCleanStrategy
import com.elvishew.xlog.printer.file.naming.DateFileNameGenerator
import com.example.dy.ui.activity.CrashActivity
import com.example.dy.util.LogEntry
import dagger.hilt.android.HiltAndroidApp
import xcrash.ICrashCallback
import xcrash.XCrash
import java.io.File
import kotlin.time.Duration.Companion.days

// 它标注一个Android应用程序的上下文类
@HiltAndroidApp
class App : Application() {
    private var TAG = "Application"

    override fun onCreate() {
        super.onCreate()

        // 初始化 XLog，关闭线程信息，并使用 AndroidPrinter 和 FilePrinter
        XLog.init(
            LogConfiguration.Builder().disableThreadInfo().build(),
            // 日志输出到安卓系统日志，开发要用
            AndroidPrinter(true),
            FilePrinter.Builder(cacheDir.resolve("logs").path)
                .fileNameGenerator(DateFileNameGenerator()) // 使用日期作为文件名
                .backupStrategy(NeverBackupStrategy()) // 不进行备份
                .cleanStrategy(FileLastModifiedCleanStrategy(15.days.inWholeMilliseconds)) // 清除 15 天前的日志文件
                .flattener { timeMillis, logLevel, tag, message ->
                    // 将日志扁平化，添加时间、日志级别、消息和标签信息
                    LogEntry(
                        time = timeMillis,
                        level = logLevel,
                        message = message,
                        thread = Thread.currentThread().name,
                        tag = tag
                    ).toString()
                }
                .build()
        )
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

        // xCrash Handler。程序崩溃运行此高阶函数
        val handler = ICrashCallback { logPath, _ ->
            val file = File(logPath)
            startActivity(
                Intent(this, CrashActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    putExtra("stackTrace", file.readLines().joinToString("\n"))
                }
            )
            file.deleteOnExit()
        }
        XCrash.init(
            this, XCrash.InitParameters()
                    // App版本
                .setAppVersion(BuildConfig.VERSION_NAME)
                    // 设置日志目录
                .setLogDir(
                    getExternalFilesDir("crash")?.path
                )
                    // 本机崩溃时要执行的回调
                .setNativeCallback(handler)
                    // 发生 ANR 时要执行的回调
                .setAnrCallback(handler)
                    // Java 异常时要执行的回调
                .setJavaCallback(handler)
        )
    }
}