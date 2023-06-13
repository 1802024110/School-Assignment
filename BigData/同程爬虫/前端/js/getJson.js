async function getJson(path) {
  // 使用fetch读取本地json/page2.json文件
  const response = await fetch(path);
  const data = await response.json();
  return data;
}