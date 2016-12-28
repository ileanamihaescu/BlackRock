import urllib
import base64
import requests
import sys
import csv
reload(sys)
sys.setdefaultencoding('utf-8')

def detect_text(image_file, access_token=None):

    with open(image_file, 'rb') as image:
        base64_image = base64.b64encode(image.read()).decode()

    url = 'https://vision.googleapis.com/v1/images:annotate?key={}'.format(access_token)
    header = {'Content-Type': 'application/json'}
    body = {
        'requests': [{
            'image': {
                'content': base64_image,
            },
            'features': [{
                'type': 'TEXT_DETECTION',
                'maxResults': 1,
            }]

        }]
    }
    response = requests.post(url, headers=header, json=body).json()
    text = response['responses'][0]['textAnnotations'][0]['description'] if len(response['responses'][0]) > 0 else ''
    return text

def main():
    for counter in range (10, 20):
    	img_name = str(counter) + ".jpg"
    	urllib.urlretrieve("http://rockthehackathons.com:5000/api/fax?app=BLK1", img_name)
    	text = detect_text(img_name, 'AIzaSyA7Ma-Rmc4JgJT0tMZYXEJyz5W32LnSltQ')
    	with open (str(counter)+'.txt','w') as text2:
    		text2.write(text)

if __name__ == '__main__':
	main()