<?
// 手动抛异常
// throw new Exception("这是一个异常");

// 同样的php也有Try和 catch用法一致

// php也能继承Exception
class MyCustomException extends Exception
{
    public function errorMessage()
    {
        // 错误信息
        $errorMsg = '错误行号 '.$this->getLine().' in '.$this->getFile()
        .': <b>'.$this->getMessage().'</b> 不是一个合法的 E-Mail 地址';
        return $errorMsg;
    }
}

// 顶层异常处理器
// et_exception_handler() 函数可设置处理所有未捕获异常的用户定义函数。.
function myTopCustomException($exception){
  echo "这是有一个Exception: $exception->getMessage()";
}
set_exception_handler("myTopCustomException");