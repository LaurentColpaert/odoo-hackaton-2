INSERT INTO tag (id_tag, tag) VALUES
(1, 'Action'),(2, 'Adventure'),(3, 'Drama'),(4, 'Romance'),(5, 'Comedy'),(6, 'Horror'),(7, 'Thriller'),(8, 'Mystery'),(9, 'Science Fiction'),(10, 'Fantasy'),
(11, 'Animation'),(12, 'Documentary'),(13, 'Crime'),(14, 'Historical'),(15, 'Biographical'),(16, 'War'),(17, 'Western'),(18, 'Martial Arts'),(19, 'Sports'),
(20, 'Music'),(21, 'Dance'),(22, 'Cooking'),(23, 'Gardening'),(24, 'Yoga'),(25, 'Pilates'),(26, 'Meditation'),(27, 'Writing'),(28, 'Reading'),(29, 'Painting'),
(30, 'Drawing'),(31, 'Sculpting'),(32, 'Photography'),(33, 'Happy'),(34, 'Sad'),(35, 'Angry'),(36, 'Joyful'),(37, 'Excited'),(38, 'Anxious'),(39, 'Nostalgic'),
(40, 'Energetic'),(41, 'Relaxed'),(42, 'Calm'),(43, 'Confused'),(44, 'Inspired'),(45, 'Amused'),(46, 'Melancholic'),(47, 'Hopeful'),(48, 'Frustrated'),(49, 'Inquisitive'),
(50, 'Satisfied'),(51, 'Curious'),(52, 'Bold'),(53, 'Timid'),(54, 'Confident'),(55, 'Doubtful'),(56, 'Loving'),(57, 'Hateful'),(58, 'Envious'),(59, 'Jealous'),
(60, 'Grateful'),(61, 'Regretful'),(62, 'Proud'),(63, 'Humble'),(64, 'Surprised'),(65, 'Disappointed'),(66, 'Content'),(67, 'Restless'),(68, 'Bored'),(69, 'Anticipating'),
(70, 'Reflective'),(71, 'Optimistic'),(72, 'Pessimistic'),(73, 'Serious'),(74, 'Playful'),(75, 'Warm'),(76, 'Cold'),(77, 'Humorous'),(78, 'Ironic'),(79, 'Sarcastic'),
(80, 'Witty'),(81, 'Intellectual'),(82, 'Emotional'),(83, 'Intense'),(84, 'Lighthearted'),(85, 'Dark'),(86, 'Mysterious'),(87, 'Sensual'),(88, 'Provocative'),
(89, 'Powerful'),(90, 'Delicate'),(91, 'Nurturing'),(92, 'Aggressive'),(93, 'Passive'),(94, 'Dynamic'),(95, 'Static'),(96, 'Fast-paced'),(97, 'Slow-paced'),
(98, 'Uplifting'),(99, 'Depressing'),(100, 'Romantic');

-- Insert into person table
INSERT INTO person (name, age, gender, country)
VALUES ('John Doe', 35, 0, 'USA'),
       ('Jane Smith', 28, 1, 'Canada'),
       ('Peter Parker', 21, 0, 'USA'),
       ('Mary Jane', 22, 1, 'USA'),
       ('Tony Stark', 45, 0, 'USA'),
       ('Natasha Romanoff', 32, 1, 'Russia');

-- Insert into language table
INSERT INTO language (language)
VALUES ('English'),
       ('French'),
       ('Spanish'),
       ('German'),
       ('Mandarin'),
       ('Japanese');

-- Insert into language_person table
INSERT INTO language_person (id_person, id_language)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (2, 3),
       (3, 1),
       (4, 1),
       (4, 2),
       (5, 1),
       (5, 4),
       (6, 1),
       (6, 3);

-- Insert into capsule table
INSERT INTO capsule (id_person, date_begin, date_end)
VALUES
    (1, '2022-01-01', '2022-12-31'),
    (1, '2023-01-01', '2023-12-31'),
    (2, '2022-06-01', '2022-11-30'),
    (2, '2023-06-01', '2023-11-30'),
    (3, '2022-03-01', '2022-08-31'),
    (3, '2023-03-01', '2023-08-31'),
    (4, '2022-04-01', '2022-09-30'),
    (5, '2022-02-01', '2022-07-31'),
    (5, '2023-02-01', '2023-07-31'),
    (6, '2022-05-01', '2022-10-31'),
    (6, '2023-05-01', '2023-10-31');


INSERT INTO experience (id_capsule, date, place)
SELECT
    -- Randomly select a capsule ID
    (SELECT id_capsule FROM capsule ORDER BY RANDOM() LIMIT 1),
    -- Generate a random date between 2020-01-01 and 2023-04-01
    strftime('%Y-%m-%d %H:%M:%S', CAST((julianday('2023-04-01') - julianday('2020-01-01')) * RANDOM() + julianday('2020-01-01') AS INTEGER)),
    -- Generate a random place from a list
    CASE CAST(RANDOM() * 10 AS INTEGER)
        WHEN 0 THEN 'New York'
        WHEN 1 THEN 'Paris'
        WHEN 2 THEN 'Tokyo'
        WHEN 3 THEN 'Sydney'
        WHEN 4 THEN 'London'
        WHEN 5 THEN 'Rio de Janeiro'
        WHEN 6 THEN 'Moscow'
        WHEN 7 THEN 'Hong Kong'
        WHEN 8 THEN 'Dubai'
        WHEN 9 THEN 'Los Angeles'
        END
FROM
    -- Repeat for each person and capsule combination
    (SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6) persons,
    (SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4) capsules
LIMIT 50;


-- Insert into tag_experience table
INSERT INTO tag_experience (id_tag, id_experience)
VALUES (1, 1),
       (2, 1),
       (2, 2),
       (3, 2),
       (1, 3),
       (4, 3),
       (1, 4),
       (5, 4),
       (1, 5),
       (6, 5),
       (1, 6),
       (6, 6);