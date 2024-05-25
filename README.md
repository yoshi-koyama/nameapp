# このプロジェクトについて

このプロジェクトでは Spring Boot と MySQL を使った CRUD 処理をもつ RESTful な Web API を作成します。

# 開発環境

- Java 17
- Spring Boot 3.2.6
- MySQL 8

# API の概要

## 名前を全件取得する API

- リクエスト
    - Method: GET
    - URL: /names
- レスポンス
    - ステータスコード: 200
    - ボディ: 名前のリストを JSON 形式で返す

```curl
curl --location 'http://localhost:8080/names'
```
