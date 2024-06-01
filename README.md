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

## 指定した ID の名前を取得する API

- リクエスト
    - Method: GET
    - URL: /names/{id}
- レスポンス
    - ステータスコード: 200
    - ボディ: 指定した ID の名前を JSON 形式で返す
    - ID が存在しない場合はステータスコード 404 を返す

```curl
curl --location 'http://localhost:8080/names/1'
```

- 200 の場合のレスポンス

```json
{
  "id": 1,
  "name": "Alice"
}
```

- 404 の場合のレスポンス

```json
{
  "message": "user not found",
  "timestamp": "2022-07-07T00:38:53.260151+09:00[Asia/Tokyo]",
  "error": "Not Found",
  "path": "/users/100",
  "status": "404"
}
```
