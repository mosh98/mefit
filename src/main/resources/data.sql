DROP TABLE IF EXISTS fit_me_user;
DROP TABLE IF EXISTS users;

--INSERT INTO user_mefit (e_mail, first_name, last_name, password, user_type, key_cloak_id) VALUES ('sample1@gmail.com', 'Miwa','Guhrés','12345','User','oiuhjkiujiuj232');
--INSERT INTO user_mefit (e_mail, first_name, last_name, password, user_type, key_cloak_id) VALUES ('sample2@gmail.com', 'Lovisa','Bohman','6789','User','ikwoeidjk23424');
--INSERT INTO profile (disabilities, height, medical_condition, profile_img, weight) VALUES ('none', 170, 'none', 'img1', 55);
--INSERT INTO profile (disabilities, height, medical_condition, profile_img, weight) VALUES ('none', 180, 'diabetes', 'img2', 100);

--INSERT INTO address (address, post_code, city,country,profile_id) VALUES ('Abcvägen 5','11111','Tumba','Sweden',1);
--INSERT INTO address (address, post_code, city,country,profile_id) VALUES ('Defvägen 6','22222','Stockholm','Sweden',2);


INSERT INTO program (name, category) VALUES ('Program 1', 'Category 1');
INSERT INTO program (name, category) VALUES ('Program 2', 'Category 2');

--INSERT INTO goal ( profile_id, end_date )VALUES ( 1, TO_DATE('03/22/2023', 'mm/dd/yyyy'));


INSERT INTO workout (name, type,experience_level,completed ) VALUES ('Chest Blaster', 'Chest', 'Beginner',false);
INSERT INTO workout (name, type,experience_level,completed ) VALUES ('Chest Blaster', 'Chest', 'Intermediate',false);
INSERT INTO workout (name, type,experience_level,completed ) VALUES ('Chest Blaster', 'Chest', 'Expert',false);

INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id, sets, reps)
VALUES ('Push-ups', 'A classic bodyweight exercise that works the chest, shoulders, and triceps.', 'Chest', 'Beginner', 1, 3, 10),
       ('Dumbbell Chest Fly', 'An isolation exercise that targets the chest muscles using dumbbells.', 'Chest', 'Beginner', 1, 3, 12),
       ('Bench Press', 'A compound exercise that works the chest, shoulders, and triceps using a barbell.', 'Chest', 'Beginner', 1, 3, 8);

INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id, sets, reps)
VALUES ('Incline Dumbbell Press', 'A variation of the dumbbell press that targets the upper chest muscles.', 'Chest', 'Intermediate', 2, 3, 10),
       ('Decline Bench Press', 'A variation of the bench press that targets the lower chest muscles using a barbell.', 'Chest', 'Intermediate', 2, 3, 8),
       ('Cable Fly', 'An isolation exercise that targets the chest muscles using cable machines.', 'Chest', 'Intermediate', 2, 3, 12);

INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id, sets, reps)
VALUES ('Weighted Dips', 'A compound exercise that works the chest, shoulders, and triceps using a dip bar and added weight.', 'Chest', 'Expert', 3, 4, 8),
       ('Incline Barbell Press', 'A variation of the bench press that targets the upper chest muscles using a barbell.', 'Chest', 'Expert', 3, 4, 6),
       ('Dumbbell Pullover', 'An isolation exercise that targets the chest and back muscles using a dumbbell.', 'Chest', 'Expert', 3, 4, 10);


INSERT INTO workout (name, type,experience_level, completed) VALUES ('Back buster', 'Back', 'Intermediate',false);
INSERT INTO workout (name, type,experience_level,completed) VALUES ('Back buster', 'Back', 'Beginner',false);
INSERT INTO workout (name, type,experience_level,completed) VALUES ('Back buster', 'Back', 'Expert',false);

INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id, sets, reps)
VALUES ('Bent-Over Barbell Rows', 'A compound exercise that targets the upper and lower back muscles using a barbell.', 'Back', 'Beginner', 4, 3, 10),
       ('Seated Cable Rows', 'An isolation exercise that targets the mid-back muscles using a cable machine.', 'Back', 'Beginner', 4, 3, 12),
       ('Reverse Fly', 'An isolation exercise that targets the rear deltoids and upper back muscles using dumbbells.', 'Back', 'Beginner', 4, 3, 12);

INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id, sets, reps)
VALUES ('Wide-Grip Pull-Up', 'A compound exercise that targets the upper back and biceps using a pull-up bar.', 'Back', 'Intermediate', 5, 3, 8),
       ('T-Bar Row', 'A compound exercise that targets the upper and mid-back muscles using a T-bar machine and weight plates.', 'Back', 'Intermediate', 5, 3, 10),
       ('One-Arm Dumbbell Row', 'An isolation exercise that targets the mid-back muscles using a dumbbell.', 'Back', 'Intermediate', 5, 3, 12);

INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id, sets, reps)
VALUES ('Deadlift', 'A compound exercise that targets the entire back, hamstrings, and glutes using a barbell.', 'Back', 'Expert', 6, 4, 6),
       ('Pull-Up (Weighted)', 'A compound exercise that targets the upper back and biceps using a pull-up bar and added weight.', 'Back', 'Expert', 6, 4, 8),
       ('Barbell Row', 'A compound exercise that targets the upper and mid-back muscles using a barbell.', 'Back', 'Expert', 6, 4, 8);


INSERT INTO workout (name, type,experience_level,completed) VALUES ('Legs smasher', 'Legs', 'Beginner',false);
INSERT INTO workout (name, type,experience_level,completed) VALUES ('Legs smasher', 'Legs', 'Intermediate',false);
INSERT INTO workout (name, type,experience_level,completed) VALUES ('Legs smasher', 'Legs', 'Expert',false);

INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id, sets, reps)
VALUES ('Squats', 'A compound exercise that targets the quads, hamstrings, and glutes using a barbell.', 'Legs', 'Beginner', 7, 3, 10),
       ('Lunges', 'An isolation exercise that targets the quads, hamstrings, and glutes using bodyweight or dumbbells.', 'Legs', 'Beginner', 7, 3, 12),
       ('Leg Press', 'A compound exercise that targets the quads, hamstrings, and glutes using a leg press machine.', 'Legs', 'Beginner', 7, 3, 12);

INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id, sets, reps)
VALUES ('Deadlifts', 'A compound exercise that targets the hamstrings, glutes, and lower back using a barbell.', 'Legs', 'Intermediate', 8, 3, 8),
       ('Barbell Squats', 'A compound exercise that targets the quads, hamstrings, and glutes using a barbell.', 'Legs', 'Intermediate', 8, 3, 8),
       ('Romanian Deadlifts', 'An isolation exercise that targets the hamstrings and glutes using a barbell or dumbbells.', 'Legs', 'Intermediate', 8, 3, 10);

INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id, sets, reps)
VALUES ('Barbell Lunges', 'An isolation exercise that targets the quads, hamstrings, and glutes using a barbell.', 'Legs', 'Expert', 9, 4, 8),
       ('Front Squats', 'A variation of the barbell squat that places more emphasis on the quads.', 'Legs', 'Expert', 9, 4, 6),
       ('Hack Squats', 'A compound exercise that targets the quads, hamstrings, and glutes using a hack squat machine or a barbell.', 'Legs', 'Expert', 9, 4, 8);

INSERT INTO workout (name, type,experience_level,completed ) VALUES ('Boulder Shoulders', 'Shoulders', 'Beginner',false);
INSERT INTO workout (name, type,experience_level,completed ) VALUES ('Boulder Shoulders', 'Shoulders', 'Intermediate',false);
INSERT INTO workout (name, type,experience_level,completed ) VALUES ('Boulder Shoulders', 'Shoulders', 'Expert',false);

INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id, sets, reps)
VALUES ('Dumbbell Shoulder Press', 'A compound exercise that targets the shoulders using dumbbells.', 'Shoulders', 'Beginner', 10, 3, 10),
       ('Lateral Raises', 'An isolation exercise that targets the lateral (side) deltoids using dumbbells.', 'Shoulders', 'Beginner', 10, 3, 12),
       ('Front Raises', 'An isolation exercise that targets the front deltoids using dumbbells.', 'Shoulders', 'Beginner', 10, 3, 12);

INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id, sets, reps)
VALUES ('Seated Barbell Press', 'A compound exercise that targets the shoulders using a barbell while seated.', 'Shoulders', 'Intermediate', 11, 3, 8),
       ('Arnold Press', 'A variation of the dumbbell press that targets all three heads of the shoulder muscles.', 'Shoulders', 'Intermediate', 11, 3, 10),
       ('Upright Rows', 'A compound exercise that targets the shoulders and upper back muscles using a barbell.', 'Shoulders', 'Intermediate', 11, 3, 12);

INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id, sets, reps)
VALUES ('Push Press', 'A compound exercise that targets the shoulders, triceps, and legs using a barbell.', 'Shoulders', 'Expert', 12, 4, 6),
       ('Handstand Push-Ups', 'A bodyweight exercise that targets the shoulders using a handstand position.', 'Shoulders', 'Expert', 12, 4, 8),
       ('Dumbbell Rear Deltoid Fly', 'An isolation exercise that targets the rear deltoids using dumbbells.', 'Shoulders', 'Expert', 12, 4, 12);



INSERT INTO workout (name, type, experience_level,completed ) VALUES ('Abs & Core', 'Shoulders', 'Beginner',false);
INSERT INTO workout (name, type, experience_level,completed ) VALUES ('Abs & Core', 'Shoulders', 'Intermediate',false);
INSERT INTO workout (name, type, experience_level,completed ) VALUES ('Abs & Core', 'Shoulders', 'Expert',false);

INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id, sets, reps)
VALUES ('Crunches', 'An isolation exercise that targets the rectus abdominis using bodyweight.', 'Abs & Core', 'Beginner', 13, 3, 15),
       ('Plank', 'An isometric exercise that targets the core muscles using bodyweight.', 'Abs & Core', 'Beginner', 13, 3, 30),
       ('Russian Twist', 'An isolation exercise that targets the obliques using bodyweight or a medicine ball.', 'Abs & Core', 'Beginner', 13, 3, 12);

INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id, sets, reps)
VALUES ('Hanging Leg Raises', 'An isolation exercise that targets the lower abs using a pull-up bar.', 'Abs & Core', 'Intermediate', 14, 3, 12),
       ('Bicycle Crunches', 'An isolation exercise that targets the obliques using bodyweight.', 'Abs & Core', 'Intermediate', 14, 3, 20),
       ('Plank with Alternating Leg Lift', 'An isometric exercise that targets the core muscles and hip flexors using bodyweight.', 'Abs & Core', 'Intermediate', 14, 3, 30);

INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id, sets, reps)
VALUES ('Dragon Flag', 'An advanced isolation exercise that targets the rectus abdominis using bodyweight.', 'Abs & Core', 'Expert', 15, 4, 8),
       ('Windshield Wipers', 'An advanced isolation exercise that targets the obliques using a pull-up bar.', 'Abs & Core', 'Expert', 15, 4, 10),
       ('L-Sit Hold', 'An advanced isometric exercise that targets the core muscles and hip flexors using bodyweight.', 'Abs & Core', 'Expert', 15, 4, 30);



--insert excercises
-- INSERT INTO exercise (name, user_experience, sets, reps, muscle_group,workout_id) VALUES ('Exercise 1', 'Beginner', 3, 10, 'Chest',1);
-- INSERT INTO exercise (name, user_experience, sets, reps, muscle_group,workout_id) VALUES ('Exercise 11', 'Beginner', 3, 10, 'Chest',1);
-- INSERT INTO exercise (name, user_experience, sets, reps, muscle_group,workout_id) VALUES ('Exercise 2', 'Intermediate', 4, 8, 'Back',2);
-- INSERT INTO exercise (name, user_experience, sets, reps, muscle_group,workout_id) VALUES ('Exercise 55', 'Intermediate', 4, 8, 'Back',2);
-- INSERT INTO exercise (name, user_experience, sets, reps, muscle_group,workout_id) VALUES ('Exercise 3', 'Advanced', 5, 6, 'Legs',3);
-- INSERT INTO exercise (name, user_experience, sets, reps, muscle_group,workout_id) VALUES ('Exercise 4', 'Beginner', 3, 10, 'Chest',4);

--INSERT INTO program_workout (program_id, workout_id) VALUES (1, 1);
--INSERT INTO program_workout (program_id, workout_id) VALUES (1, 2);

--INSERT INTO program_workout (program_id, workout_id) VALUES (2, 3);
--INSERT INTO program_workout (program_id, workout_id) VALUES (2, 4);
--INSERT INTO program_workout (program_id, workout_id) VALUES (2, 1);

-- INSERT INTO program_workout (program_id, workout_id) VALUES (1, 2);

--Excercises
-- Excercises for abdominals






-- chest
-- Insert exercise 1 for chest
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id,sets,reps)
-- VALUES ('Barbell bench press', 'Lift the bar from the rack and hold it straight over you with your arms locked. Lower it slowly until it skims the middle of your chest, then push it back to the starting position. Intermediate level.', 'chest', 'intermediate', 1,3,8);
--
-- -- Insert exercise 2 for chest
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id,sets,reps)
-- VALUES ('Dumbbell flyes', 'Lie on a flat bench with a dumbbell on each hand. Slowly lower the dumbbells to the side, feeling the chest muscles stretch. Inhale and bring your arms back up. Intermediate level.', 'chest', 'intermediate', 1,3,12);
--
-- --back
-- -- Insert exercise 1 for back
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id,sets,reps)
-- VALUES ('Lat pulldown', 'Sit down on a pull-down machine with a wide bar attached to the top pulley. Bring the bar down until it touches your upper chest. Intermediate level.', 'back', 'intermediate', 2,3,8);
--
-- -- Insert exercise 2 for back
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id,sets,reps)
-- VALUES ('Dumbbell rows', 'Choose a flat bench and place a dumbbell on each side of it. With a flat back, pull the weight up to your side until your elbow forms a 90-degree angle. Beginner level.', 'back', 'beginner', 2,3,12);
--
-- --legs
-- -- Insert exercise 1 for legs
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id,sets,reps)
-- VALUES ('Squats', 'Stand with your feet shoulder-width apart, keeping your back straight. Lower your body until your thighs are parallel to the ground. Push back up to the starting position. Beginner level.', 'legs', 'beginner', 3,3,6);
--
-- -- Insert exercise 2 for legs
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id,sets,reps)
-- VALUES ('Lunges', 'Take a step forward, dropping your back knee towards the ground. Push back up to the starting position, then repeat with the other leg. Intermediate level.', 'legs', 'intermediate', 3,3,8);
--
-- --shoulders
-- -- Insert exercise 1 for shoulders
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id,sets,reps)
-- VALUES ('Overhead press', 'Stand with your feet shoulder-width apart, holding a weight in each hand. Push the weights up overhead, then lower them back down. Intermediate level.', 'shoulders', 'intermediate', 5,3,8);
--
-- -- Insert exercise 2 for shoulders
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id,sets,reps)
-- VALUES ('Front raises', 'Stand with your feet shoulder-width apart, holding a weight in each hand. Raise the weights up in front of you, then lower them back down. Beginner level.', 'shoulders', 'beginner', 5,3,6);
--
-- -- Insert exercise 1 for shoulders
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id, sets, reps)
-- VALUES ('Lateral raises', 'Stand with your feet shoulder-width apart, holding a weight in each hand. Raise the weights out to the sides until they reach shoulder height, then lower them back down. Intermediate level.', 'shoulders', 'intermediate', 5, 3, 12);
--
-- -- Insert exercise 2 for shoulders
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id, sets, reps)
-- VALUES ('Handstand push-ups', 'Get into a handstand position with your hands on the ground and your feet against a wall. Lower your head down towards the ground, then push back up. Advanced level.', 'shoulders', 'expert', 5, 5, 5);
--
-- --chest
-- -- Insert exercise 1 for chest
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id,sets,reps)
-- VALUES ('Barbell bench press', 'Lift the bar from the rack and hold it straight over you with your arms locked. Lower it slowly until it skims the middle of your chest, then push it back to the starting position. Expert level.', 'chest', 'expert', 1,4,10);
--
-- -- Insert exercise 2 for chest
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id,sets,reps)
-- VALUES ('Dumbbell flyes', 'Lie on a flat bench with a dumbbell on each hand. Slowly lower the dumbbells to the side, feeling the chest muscles stretch. Inhale and bring your arms back up. Expert level.', 'chest', 'expert', 1,4,12);
--
-- --back
-- -- Insert exercise 1 for back
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id,sets,reps)
-- VALUES ('Deadlifts', 'Stand with your mid-foot under the bar. Grab the bar, keeping your shoulders over the bar and your hips high. Lift the bar by extending your hips and knees. Expert level.', 'back', 'expert', 2,4,8);
--
-- -- Insert exercise 2 for back
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id,sets,reps)
-- VALUES ('Chin-ups', 'Grab onto a pull-up bar with your palms facing towards you. Pull yourself up until your chin is over the bar, then lower yourself back down. Expert level.', 'back', 'expert', 2,4,10);
--
-- --legs
-- -- Insert exercise 1 for legs
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id,sets,reps)
-- VALUES ('Barbell squats', 'Stand with your feet shoulder-width apart, keeping your back straight. Lower your body until your thighs are parallel to the ground. Push back up to the starting position. Expert level.', 'legs', 'expert', 3,4,6);
--
-- -- Insert exercise 2 for legs
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id,sets,reps)
-- VALUES ('Bulgarian split squats', 'Stand with one foot forward and the other foot back on a bench. Lower your body until your front thigh is parallel to the ground, then push back up to the starting position. Switch legs and repeat. Expert level.', 'legs', 'expert', 3,4,8);
--
-- --shoulders
-- -- Insert exercise 1 for shoulders
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id,sets,reps)
-- VALUES ('Military press', 'Stand with your feet shoulder-width apart, holding a barbell in front of you. Push the barbell up overhead, then lower it back down to the starting position. Expert level.', 'shoulders', 'expert', 5,4,8);
--
-- -- Insert exercise 2 for shoulders
-- INSERT INTO exercise(name, description, muscle_group, user_experience, workout_id,sets,reps)
-- VALUES ('Lateral raises', 'Stand with your feet shoulder-width apart, holding a weight in each hand. Raise the weights out to the sides until they reach shoulder height, then lower them back down. Expert level.', 'shoulders', 'expert', 5,4,12);
