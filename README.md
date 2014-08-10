This is a classic CRUD application sample
=================================

- Using Play Framework 2.3 for Java
- Accessing a JDBC database, using JPA (Hibernate).
- Implemented a CRUD and form validation, have relationship
  - bi-directional one-to-one relationship with shared primary key
  - bi-directional one-to-many relationship
  - bi-directional many-to-many relationship(work in progress)


PlayFramwork2.3 for Javaのサンプルアプリケーションです
------------------------------------------

オブジェクトの関連も含めたJPAのPlayのチュートリアルがなかったので作りました

関連を持っている場合のFormのバリデーションにも触れています

アノテーションの付け方の参考にしてください

- JPA(Hibernate)を使っています
- オブジェクトの関連は以下のものを取り扱っています
  - 同じ主キーを持つ1対1
  - 1対多
  - 多対多（中間テーブルを持つ形での1対多）
- ORMだけに注目するためにあえてCSSフレームワークは入れていません
