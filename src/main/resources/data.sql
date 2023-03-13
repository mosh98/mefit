-- INSERT INTO fit_me_user (e_mail, password, first_name, last_name) VALUES ('userexam1@se.experis.com', '12345', 'Miwa', 'Guhres');
-- INSERT INTO fit_me_user (e_mail, password, first_name, last_name) VALUES ('userexam2@se.experis.com', '6789', 'Silvia', 'Alvarez Allende');
--INSERT INTO user(e_mail) VALUES ('abc');
INSERT INTO program (name, category) VALUES ('Program 1', 'Category 1');
INSERT INTO program (name, category) VALUES ('Program 2', 'Category 2');

INSERT INTO workout (name, type, completed ) VALUES ('Workout 1', 'Type 1', false);
INSERT INTO workout (name, type, completed) VALUES ('Workout 2', 'Type 2', true);
INSERT INTO workout (name, type, completed) VALUES ('Workout 3', 'Type 1', false);
INSERT INTO workout (name, type, completed) VALUES ('Workout 4', 'Type 2', true);


INSERT INTO program_workout (program_id, workout_id) VALUES (1, 1);
INSERT INTO program_workout (program_id, workout_id) VALUES (1, 2);


INSERT INTO program_workout (program_id, workout_id) VALUES (2, 3);
INSERT INTO program_workout (program_id, workout_id) VALUES (2, 4);
INSERT INTO program_workout (program_id, workout_id) VALUES (2, 1);

-- INSERT INTO program_workout (program_id, workout_id) VALUES (1, 2);