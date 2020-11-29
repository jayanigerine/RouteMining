 ![](src/main/resources/screen-shots/sequence.png)
##### Steps to run the project
- If not already present, create a folder `upload-dir` at same level as `src`. This is the folder where uploaded
 files as well as generated reports will be stored.
- To run the project, use the command `mvn spring-boot:run`. This will start the web-application on the port `8080`
- `http://localhost:8080` will take you the home page of the application.
 ![](src/main/resources/screen-shots/1.png)
- You have option to enter one address and get its corrected address, carrier route and number of addresses in that
 carrier route or upload a batch of addresses in `.csv` file. When you upload a `.csv` file, it generates 2 reports
  which can be downloaded. 
- Lets try the first option. We will enter the address `4901 Evergreeen Rd, Dearbornn, mi, 48128`. Please note the
 spelling mistakes in address. When you hit `Get corrected address` button, it returns corrected address and its
  corresponding carrier route id.
 ![](src/main/resources/screen-shots/2.png) 
- Now click the `Get address count in route` button. It returns total address count in that route. This result count
 matches the `Mellisa data` record, hence we can be sure that it is working accurately.
 ![](src/main/resources/screen-shots/3.png) 
 ![](src/main/resources/screen-shots/4.png) 
 ![](src/main/resources/screen-shots/5.png)

- Lets try another address

    ![](src/main/resources/screen-shots/6.png)

- Lets try to upoad a input csv file
    ![](src/main/resources/screen-shots/7.png)
- Uploaded file will be parsed, calls will be made to USPS APIs and following 2 reports will be generated, which can
 be downloaded.
 
    ![](src/main/resources/screen-shots/8.png)
    
- Lets look at the reports generated
 ![](src/main/resources/screen-shots/9.png)
 ![](src/main/resources/screen-shots/10.png)


 