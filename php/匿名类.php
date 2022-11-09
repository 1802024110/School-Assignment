<?
interface Logger{
  public function say();
}
function a(Logger $q):void{
  $q->say();
}
a(new class implements Logger{
  public function say(){
    echo "你好世界";
  }
});