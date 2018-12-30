---

San Diego Supercomputer Center
=========
## Web Crawling Project - Spyder

Main Document can be found in Spider/src/com/example/CSEOneStep.java

Main functions:

- Read rawurl.txt seed file and generate requests
- Use Google Custom Search to get the most updated content of seed websites (e.g. 1 day);
- Extract urls elments from the acquired JSON file and delete the unwanted urls(ads,emails,surveys,etc.)
- Nutch crawl result and Solr parser the index
- Clean up the JSON file
- Convert the JSON file into CSV for topic models


### Output 1 - Result.txt (links extracted from json-extract.txt)
[![image](https://github.com/huangbeidan/Spider/blob/master/assets/output11.png)](#capture)

### Output 2 - json-extract.txt (Files fetched from Google Custom Search)
[![image](https://github.com/huangbeidan/Spider/blob/master/assets/output22.png)](#capture)

### Output 3 - json22csv.csv (Cleaned up results after Nutch and Solr, with url, content displayed)
[![image](https://github.com/huangbeidan/Spider/blob/master/assets/output33.png)](#capture)
