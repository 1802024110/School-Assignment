<?
// json_encode 对变量进行 JSON 编码
// 该函数如果执行成功返回 JSON 数据，否则返回 FALSE 。
// 参数一是被编码的值，可选参数二是二进制掩码
/** 参数二
 *JSON_HEX_QUOT, JSON_HEX_TAG, JSON_HEX_AMP, JSON_HEX_APOS, JSON_NUMERIC_CHECK, JSON_PRETTY_PRINT, JSON_UNESCAPED_SLASHES, JSON_FORCE_OBJECT, JSON_PRESERVE_ZERO_FRACTION, JSON_UNESCAPED_UNICODE, JSON_PARTIAL_OUTPUT_ON_ERROR。
 *要注意的是 JSON_UNESCAPED_UNICODE 选项，如果我们不希望中文被编码，可以添加该选项。
 */
$json1 = "{
  data :1
}";
$json2 = array('msg'=>"你好世界","data"=>array("name"=>"小王","age"=>"18"));
var_dump(json_encode($json1));
var_dump(json_encode($json2));

// json_decode 对 JSON 格式的字符串进行解码，转换为 PHP 变量
// 参数一：待解码的JSON字符串
// 参数二：true返回数组，false返回对象,默认false
// 参数三：指定递归深度，整形
// 参数四：掩码，只支持 SON_BIGINT_AS_STRING 。
$json = '{"a":1,"b":2,"c":3,"d":4,"e":5}';
var_dump(json_decode($json));

// json_last_error 返回最后发生的错误
$json3 = "{'Organization''PHP Documentation Team'}"; // 错误的JSON字符串
json_decode($json3); // 返回false，但是不会抛出错误
echo json_last_error();// 这里获取最近一次json错误代码。