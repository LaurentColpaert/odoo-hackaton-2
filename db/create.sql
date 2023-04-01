
CREATE TABLE "person" (
	"id_person"	INTEGER,
	"name"	TEXT NOT NULL,
	"age"	INTEGER NOT NULL,
	"gender"	INTEGER NOT NULL,
	"country"	TEXT NOT NULL,
	PRIMARY KEY("id_person")
);

CREATE TABLE "language" (
	"id_language"	INTEGER,
	"language"	TEXT NOT NULL,
	PRIMARY KEY("id_language")
);

CREATE TABLE "language_person" (
	"id_person"	INTEGER,
	"id_language"	INTEGER,
	FOREIGN KEY("id_person") REFERENCES "person"("id_person"),
	FOREIGN KEY("id_language") REFERENCES "language"("id_language")
);

CREATE TABLE "capsule" (
	"id_capsule"	INTEGER,
	"id_person"	INTEGER,
	"date_begin"	TEXT NOT NULL,
	"date_end"	TEXT NOT NULL,
	FOREIGN KEY("id_person") REFERENCES "person"("id_person"),
	PRIMARY KEY("id_capsule")
);

CREATE TABLE "experience" (
	"id_experience"	INTEGER,
	"id_capsule"	INTEGER,
	"date"	TEXT NOT NULL,
	"place"	TEXT,
	PRIMARY KEY("id_experience"),
	FOREIGN KEY("id_capsule") REFERENCES "capsule"("id_capsule")
);


CREATE TABLE "tag" (
	"id_tag"	INTEGER,
	"tag"	TEXT NOT NULL,
	PRIMARY KEY("id_tag" AUTOINCREMENT)
)

CREATE TABLE "tag_experience" (
	"id_tag"	INTEGER,
	"id_experience"	INTEGER,
	FOREIGN KEY("id_experience") REFERENCES "experience"("id_experience"),
	FOREIGN KEY("id_tag") REFERENCES "tag"("id_tag")
);