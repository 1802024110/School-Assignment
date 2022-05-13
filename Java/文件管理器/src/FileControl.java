import java.io.File;

public class FileControl {
    /**
     *  根据关键字查找文件夹下的文件
     * @param path String
     * @param keyWord String
     */
    public void searchForkeyWord(String path, String keyWord) {
        //  TODO 根据路径和关键字查找文件
        if(keyWord == null || keyWord.equals("")){
            System.out.println("不能为空");
            return;
        }
        File file = new File(path);
        // 新建一个File对象来指向指定路径
        if (!file.exists()) {
            System.out.println("这是一个不存在的路径");
            return;
        }
        // 判断路径是否存在
        if (file.isDirectory()) {
            // 如果是目录，则遍历该目录下的所有文件
            File[] files = file.listFiles();
            // 获取文件夹下的文件和文件夹
            if (files == null) {return;}
            // 到了最底层的文件夹就退出，不然会空指针异常
            for (File f : files) {
                if(f.isDirectory()){
                    searchForkeyWord(f.getAbsolutePath(), keyWord);
                    // 如果是文件夹，则递归调用
                }else {
                    if (f.getName().contains(keyWord)) {
                        // 如果是文件，则判断是否包含关键字
                        System.out.println(f.getAbsolutePath());
                    }
                }
            }
        }
    }
    /**
     *  根据后缀名查找文件夹下的文件
     *  @param path String
     *  @param suffix String[]
     */
    public void searchForSuffix(String path, String[] suffix) {
        //  TODO 根据路径和后缀名查找文件
        if(suffix == null || suffix.length == 0){
            System.out.println("不能为空");
            return;
        }
        File file = new File(path);
        // 新建一个File对象来指向指定路径
        if (!file.exists()) {
            System.out.println("这是一个不存在的路径");
        }
        // 判断路径是否存在
        if (file.isDirectory()) {
            // 如果是目录，则遍历该目录下的所有文件
            File[] files = file.listFiles();
            // 获取文件夹下的文件和文件夹
            if (files == null) {return;}
            for (File f : files) {
                if(f.isDirectory()){
                    searchForSuffix(f.getAbsolutePath(), suffix);
                    // 如果是文件夹，则递归调用
                }
                else {
                    for (String s : suffix) {
                        if (f.getName().endsWith(s)) {
                            // 如果是文件，则判断是否包含关键字
                            System.out.println(f.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }

    /**
     * 删除目录下的所有文件
     * @param args String[]
     */
    public void deleteAllFile(String[] args) {
        //  TODO 删除目录下的所有文件
        if(args == null || args.length == 0){
            System.out.println("不能为空");
            return;
        }
        for (String s : args) {
            File file = new File(s);
            if (!file.exists()) {
                System.out.println("这是一个不存在的路径");
                return;
            }
            // 删除该目录
            if(!file.isFile()){
                File[] files = file.listFiles();
                for(int i = 0; i < files.length; i++){
                    String[] filePath = {files[i].getAbsolutePath()};
                    deleteAllFile(filePath);
                    files[i].delete();
                }
            }else {
                file.delete();
            }
            file.delete();
        }
    }
}
