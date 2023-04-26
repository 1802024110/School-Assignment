import requests
from PIL import Image
from io import BytesIO

def display_image_from_url(url):
    response = requests.get(url)
    img_data = BytesIO(response.content)
    img = Image.open(img_data)
    img.show()

# 示例：显示图片
image_url = "https://www.dmoe.cc/random.php"
display_image_from_url(image_url)
