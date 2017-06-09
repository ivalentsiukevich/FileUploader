# FileUploader (Загрузчик файлов)
### Валентюкевича Ильи КБ-151
Консольное приложение для загрузки файлов из сети по HTTP протоколу.

## Запуск программы через консоль
* Скачивание одного файла

  java -jar FileUploader-1.0-SNAPSHOT.jar -l https://www.example.com/ -p /home/tmp/ -n index.html
  
  | Параметр | Значение |
  |----------|----------|
  | -l       | ссылка на файл |
  | -p       | путь на файловой системе, куда нужно сохранить файл |
  | -n       | имя файла |
  
* Скачивание файлов из предложенного списка

  java -jar FileUploader-1.0-SNAPSHOT.jar -f my_file.xml -p /home/tmp/
  
  | Параметр | Значение |
  |----------|----------|
  | -f       | файл со списком ссылок и названий скачиваемых файлов |
  | -p       | путь на файловой системе, куда нужно сохранить файлы |
  
  Программа поддерживает следующие форматы файлов: CSV, XML, JSON
  
  * CSV
    ```
    https://www.example_1.com/,file_1.html
    https://www.example_2.com/,file_2.html
    ```
  * XML
  
    ```
    <?xml version="1.0"?>
    <files>
      <file>
        <url>https://www.example_1.com/</url>
        <name>example_1.html</name>
      </file>
      <file>
        <url>https://www.example_2.com/</url>
        <name>example_2.html</name>
      </file>
    </files>
      ```
  * JSON
    ```
    {
      "files":[
          {
              "url":"https://www.example_1.com/",
              "name":"example_1.html"
          },
          {
              "url":"https://www.example_2.com/",
              "name":"example_2.html"
          }
      ]
    }
    ```
* Параллельное скачивание файлов из списка

  java -jar FileUploader-1.0-SNAPSHOT.jar -f my_file.xml -p /home/tmp/ -t 2
    
  | Параметр | Значение |
  |----------|----------|
  | -f       | файл со списком ссылок и названий скачиваемых файлов |
  | -p       | путь на файловой системе, куда нужно сохранить файлы |
  | -t       | количество потоков |
    
  
