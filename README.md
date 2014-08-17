This is a classic CRUD application sample
----------------------------------------

- Using Play Framework 2.3 for Java
- Accessing a JDBC database, using JPA (Hibernate).
- Implemented a CRUD and form validation, have relationship
  - bi-directional one-to-one relationship with shared primary key
  - bi-directional one-to-many relationship
  - bi-directional many-to-many relationship
- Entity relationship are
  - *User* has a *Address* (User has name, email etc., Address has city, zipcode ...etc)
  - *User* has many *Post* (Post is like a blog content)
  - *Post* has many *Tag* (Tag is like a blog category)
  - *Tag* has many *Post* (Post also have the same tag with other post)

```
[User] 1..1 [Address]
[User] 1..* [Post]
[Post] *..1 [PostTags] 1..* [Tag]
```


PlayFramwork2.3 for Javaのサンプルアプリケーションです
------------------------------------------

オブジェクトの関連も含めたJPAのPlayのチュートリアルがなかったので作りました

関連を持っている場合のFormのバリデーションにも触れています

アノテーションの付け方の参考にしてください

- ORMだけに注目するためにあえてCSSフレームワークは入れていません
- JPA(Hibernate)を使っています
- オブジェクトの関連は以下のものを取り扱っています
  - 同じ主キーを持つ1対1
  - 1対多
  - 多対多（中間テーブルを持つ形での1対多）
- モデルの関係は
  - *User* は *Address* を一つ持っています。(ユーザーは、名前とかメールアドレス、アドレスは都道府県とか郵便番号とか持ってるイメージ)
  - *User* は *Post* を複数持つことができる。(ポストはブログの投稿みたいなもの)
  - *Post* は *Tag* を複数もつことができる。 (タグはブログにつけるカテゴリみたいなもの)
  - *Tag* は *Post* を複数もつことができる。（タグは他の投稿と同じものがつけられるということ） 

```
[User] 1..1 [Address]
[User] 1..* [Post]
[Post] *..1 [PostTags] 1..* [Tag]
```
