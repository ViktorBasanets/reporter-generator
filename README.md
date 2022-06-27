# Report-Generator
### Prerequisites
1. JDK 1.8.XX or higher
2. Apache Maven 3.x
3. Docker version 20.x
4. Git (Git GUI and Git Bash)
### Short description how to simply run using DOCKER
##### Clone the project from githum.com:
```bash
git clone git@github.com:ViktorBasanets/reporter-generator.git
```
##### Next you need to run following command in terminal:
```bash
cd reporter-generator
mvn clean install
```
##### after:
```bash
docker build -t reporter:1.0 .
docker run reporter:1.0
```
##### And you will see the report