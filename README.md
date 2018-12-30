---

Bear-Maps
=========
## Web Crawling Project - Spyder

Main Document can be found in Spider/src/com/example/CSEOneStep.java

Main functions:

- Read rawurl.txt seed file and generate requests to Google Custom Search
- Return result JSON files and save them into local disk
- Extract all the links from all the JSON files and write the link file to local disk
- Nutch crawl result and Solr parser the index
- Clean up the JSON file
- Convert the JSON file into CSV for topic models


### Output 1 - Result.txt (links extracted from json-extract.txt)
[![image](https://github.com/huangbeidan/Spider/assets/output11.png)](#capture)

### Output 2 - json-extract.txt (Files fetched from Google Custom Search)
[![image](https://github.com/huangbeidan/Spider/assets/output22.png)](#capture)

### Output 3 - json22csv.csv (Cleaned up results after Nutch and Solr, with url, content displayed)
[![image](https://github.com/huangbeidan/Spider/assets/output33.png)](#capture)
