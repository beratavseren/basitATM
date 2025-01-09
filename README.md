# Flask API Docker Uygulaması

Bu proje, Flask ile geliştirilmiş basit bir API'yi içerir ve Docker kullanılarak izole edilmiş bir ortamda çalıştırılabilir.

## Proje Yapısı

- `app.py`: Flask uygulamanızın ana dosyası.
- `Dockerfile`: Flask uygulamasını bir Docker imajına dönüştüren yapılandırma dosyası.
- `requirements.txt`: Flask ve diğer bağımlılıkların listesi.

## Gerekli Araçlar

Bu projeyi çalıştırabilmek için aşağıdaki araçların yüklü olması gerekmektedir:
- [Docker](https://www.docker.com/products/docker-desktop)

## Docker İmajı Oluşturma

Aşağıdaki adımları takip ederek Docker imajınızı oluşturabilirsiniz:

1. Proje dizininde terminal veya komut istemcisini açın.
2. Docker imajını oluşturmak için şu komutu çalıştırın:

    ```bash
    docker build -t flask-api .
    ```

    - `-t flask-api`: Bu seçenek, imajınızı **`flask-api`** olarak adlandıracaktır.
    - `.`: Dockerfile'ın bulunduğu mevcut dizini belirtir.

3. İmajın başarıyla oluşturulup oluşturulmadığını kontrol etmek için:

    ```bash
    docker images
    ```

    Bu komut, mevcut Docker imajlarını listeleyecek ve **`flask-api`** imajını görmelisiniz.

## Docker Konteynerini Çalıştırma

Oluşturduğunuz Docker imajını bir konteyner olarak çalıştırmak için aşağıdaki komutu kullanın:

```bash
docker run -d -p 5000:5000 --name flask-api-container flask-api

## Docker konteyneri çalıştığını kontrol etme

oluşturulan konteynerın çalışıp çalışmadığını kontol etmek için aşağıdaki komutu kullanın:
```bash
docker ps

eğer konteyner çalışıyor ise listelenecektir.
