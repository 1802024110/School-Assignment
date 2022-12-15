package com.example.dy.ui.activity

import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavBackStackEntry
import com.example.dy.ui.local.LocalNavController
import com.example.dy.ui.model.RouterViewModel
import com.example.dy.ui.screen.index.IndexScreen
import com.example.dy.ui.ui.theme.DyTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

// 确保启动时会被初始化注解
@AndroidEntryPoint
class RouterActivity : AppCompatActivity(){
    val viewModel: RouterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        // 启动图初始化.
        // 参考文章: https://developer.android.google.cn/guide/topics/ui/splash-screen?hl=zh-cn
        // https://juejin.cn/post/7026188311198695432
        installSplashScreen()

        setContent{
            // 导航控制器
            val navController = rememberAnimatedNavController()

            // Compose的 变量作用域限定工具
            // 参考文章: https://developer.android.google.cn/jetpack/compose/compositionlocal?hl=zh-cn
            CompositionLocalProvider(
                LocalNavController provides navController
            ){
                DyTheme{
                    AnimatedNavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colors.background),
                        navController = navController,
                        // 默认路由
                        startDestination = "index",
                        enterTransition = Transition.defaultEnterTransition,
                        exitTransition = Transition.defaultExitTransition,
                        popEnterTransition = Transition.defaultPopEnterTransition,
                        popExitTransition = Transition.defaultPopExitTransition
                    ){
                        composable("index"){
                            IndexScreen(navController)
                        }
                    }
                }
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // 禁止强制暗色模式
            // 国产UI似乎必需这样做(isForceDarkAllowed = false)才能阻止反色，原生会自动识别
            val existingComposeView = window.decorView
                .findViewById<ViewGroup>(android.R.id.content)
                .getChildAt(0) as? ComposeView
            existingComposeView?.isForceDarkAllowed = false
        }


    }
}

@Preview
@Composable
fun `预览`(){

}

internal object Transition {
    val defaultEnterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition) = {
        slideInHorizontally(
            initialOffsetX = {
                it
            },
            animationSpec = tween()
        )
    }

    val defaultExitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition) = {
        slideOutHorizontally(
            targetOffsetX = {
                -it
            },
            animationSpec = tween()
        ) + fadeOut(
            animationSpec = tween()
        )
    }

    val defaultPopEnterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition) =
        {
            slideInHorizontally(
                initialOffsetX = {
                    -it
                },
                animationSpec = tween()
            )
        }

    val defaultPopExitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition) = {
        slideOutHorizontally(
            targetOffsetX = {
                it
            },
            animationSpec = tween()
        )
    }
}