# Temel Python imajını kullanıyoruz
FROM python:3.9-slim

# Çalışma dizinini ayarla
WORKDIR /app

# Gereksinimleri içeren dosyayı kopyala
COPY requirements.txt requirements.txt

# Bağımlılıkları yükle
RUN pip install --no-cache-dir -r requirements.txt

# Uygulama dosyasını kopyala
COPY . .

# 5000 portunu aç
EXPOSE 5000

# Flask uygulamasını başlat
CMD ["python", "app.py"]