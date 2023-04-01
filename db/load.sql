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

-- insert sample person data
INSERT INTO person (name, age, gender, country) VALUES
                                                    ('John Smith', 25, 1, 'USA'),
                                                    ('Jane Doe', 30, 2, 'Canada'),
                                                    ('Bob Johnson', 45, 1, 'Australia'),
                                                    ('Mary Williams', 28, 2, 'UK');

-- insert sample language data
INSERT INTO language (language) VALUES
                                    ('English'),
                                    ('French'),
                                    ('Spanish'),
                                    ('Chinese');

-- insert sample language_person data
INSERT INTO language_person (id_person, id_language) VALUES
                                                         (1, 1),
                                                         (1, 2),
                                                         (2, 1),
                                                         (2, 3),
                                                         (3, 1),
                                                         (4, 2),
                                                         (4, 3),
                                                         (4, 4);

-- insert sample capsule data
INSERT INTO capsule (id_person, date_begin, date_end) VALUES
                                                          (1, '2022-01-01', '2023-01-01'),
                                                          (2, '2022-02-01', '2023-02-01'),
                                                          (3, '2022-03-01', '2023-03-01'),
                                                          (4, '2022-04-01', '2023-04-01');

-- insert sample experience data
INSERT INTO experience (id_capsule, date, place) VALUES
                                                     (1, '2022-01-10', 'New York'),
                                                     (1, '2022-02-10', 'Paris'),
                                                     (2, '2022-03-10', 'Madrid'),
                                                     (3, '2022-04-10', 'Sydney'),
                                                     (3, '2022-05-10', 'London'),
                                                     (4, '2022-06-10', 'Beijing'),
                                                     (4, '2022-07-10', 'Tokyo');


-- insert sample tag_experience data
INSERT INTO tag_experience (id_tag, id_experience) VALUES
                                                       (1, 1),
                                                       (2, 1),
                                                       (2, 2),
                                                       (3, 2),
                                                       (3, 3),
                                                       (4, 3),
                                                       (4, 5),
                                                       (5, 4),
                                                       (5, 7),
                                                       (6, 6),
                                                       (7, 5),
                                                       (8, 4);