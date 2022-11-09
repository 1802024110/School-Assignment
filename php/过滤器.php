<?
// 过滤器可以验证和过滤数据

// 过滤变量
// filter_var() 通过指定的过滤器来过滤单一的变量
// filter_var_array() 通过指定的过滤器来过多个的变量
// filter_input 过滤输入的变量
// filter_input_array 通过相同或不同的过滤器来过滤输入的多个变量
echo filter_var("123",FILTER_VALIDATE_INT);

// 自定义过滤器
function convertSpace($string)
{
    return str_replace("_", ".", $string);
}

$string = "www_runoob_com!";

echo filter_var($string, FILTER_CALLBACK,
array("options"=>"convertSpace"));