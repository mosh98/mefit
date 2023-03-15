DROP TABLE IF EXISTS fit_me_user;
DROP TABLE IF EXISTS users;

INSERT INTO user_mefit (e_mail, first_name, last_name, password, user_type) VALUES ('sample1@gmail.com', 'Miwa','Guhrés','12345','User');
INSERT INTO user_mefit (e_mail, first_name, last_name, password, user_type) VALUES ('sample2@gmail.com', 'Lovisa','Bohman','6789','User');
INSERT INTO profile (disabilities, height, medical_condition, profile_img, weight, user_id) VALUES ('none', 170, 'none', 'img1', 55, 1);
INSERT INTO profile (disabilities, height, medical_condition, profile_img, weight, user_id) VALUES ('none', 180, 'diabetes', 'img2', 100, 2);

INSERT INTO address (address, post_code, city,country,profile_id) VALUES ('Abcvägen 5','11111','Tumba','Sweden',1);
INSERT INTO address (address, post_code, city,country,profile_id) VALUES ('Defvägen 6','22222','Stockholm','Sweden',2);


INSERT INTO program (name, category) VALUES ('Program 1', 'Category 1');
INSERT INTO program (name, category) VALUES ('Program 2', 'Category 2');

INSERT INTO goal ( profile_id, end_date )VALUES ( 1, TO_DATE('03/22/2023', 'mm/dd/yyyy'));


INSERT INTO workout (name, type ) VALUES ('Workout 1', 'Type 1');
INSERT INTO workout (name, type) VALUES ('Workout 2', 'Type 2');
INSERT INTO workout (name, type) VALUES ('Workout 3', 'Type 1');
INSERT INTO workout (name, type ) VALUES ('Workout 4', 'Type 2');


--insert excercises
INSERT INTO exercise (name, user_experience, sets, reps, muscle_group,workout_id) VALUES ('Exercise 1', 'Beginner', 3, 10, 'Chest',1);
INSERT INTO exercise (name, user_experience, sets, reps, muscle_group,workout_id) VALUES ('Exercise 11', 'Beginner', 3, 10, 'Chest',1);
INSERT INTO exercise (name, user_experience, sets, reps, muscle_group,workout_id) VALUES ('Exercise 2', 'Intermediate', 4, 8, 'Back',2);
INSERT INTO exercise (name, user_experience, sets, reps, muscle_group,workout_id) VALUES ('Exercise 55', 'Intermediate', 4, 8, 'Back',2);
INSERT INTO exercise (name, user_experience, sets, reps, muscle_group,workout_id) VALUES ('Exercise 3', 'Advanced', 5, 6, 'Legs',3);
INSERT INTO exercise (name, user_experience, sets, reps, muscle_group,workout_id) VALUES ('Exercise 4', 'Beginner', 3, 10, 'Chest',4);



INSERT INTO program_workout (program_id, workout_id) VALUES (1, 1);
INSERT INTO program_workout (program_id, workout_id) VALUES (1, 2);


INSERT INTO program_workout (program_id, workout_id) VALUES (2, 3);
INSERT INTO program_workout (program_id, workout_id) VALUES (2, 4);
INSERT INTO program_workout (program_id, workout_id) VALUES (2, 1);

-- INSERT INTO program_workout (program_id, workout_id) VALUES (1, 2);