from flask import Flask
from flask_restful import Api, Resource

app = Flask(__name__)
api = Api(app)


class Toplam(Resource):
    def get(self, sayi1, sayi2):
        return {'toplam': sayi1+sayi2}


class Carpim(Resource):
    def post(self, sayi1, sayi2):
        return {'carpim': sayi1*sayi2}


api.add_resource(Toplam, '/toplam/<int:sayi1>+<int:sayi2>')
api.add_resource(Carpim, '/carpim/<int:sayi1>*<int:sayi2>')

if __name__ == '__main__':
    app.run(host='0.0.0.0',debug=True,port=5000)
