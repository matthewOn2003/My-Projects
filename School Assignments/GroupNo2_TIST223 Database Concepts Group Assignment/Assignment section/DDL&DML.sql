CREATE DATABASE human_resources_management_system;
USE human_resources_management_system;




-- CREATE TABLE
CREATE TABLE `attendance_record`  (
  `attendance_record_id` int NOT NULL AUTO_INCREMENT,
  `record_date` date NULL DEFAULT NULL,
  `time_in` time NULL DEFAULT NULL,
  `time_out` time NULL DEFAULT NULL,
  `OT_Record_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`attendance_record_id`) USING BTREE,
  INDEX `FK_Attendance_Record_OT_Record_id`(`OT_Record_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

CREATE TABLE `candidates`  (
  `Candidate_id` int NOT NULL AUTO_INCREMENT,
  `Candidate_name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Email` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone_no` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Skill_set_id` int NULL DEFAULT NULL,
  `position_Opening_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`Candidate_id`) USING BTREE,
  INDEX `FK_CANDIDATES_POSITION_OPENING_ID`(`position_Opening_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `contracts`  (
  `contract_id` int NOT NULL AUTO_INCREMENT,
  `emp_files_id` int NULL DEFAULT NULL,
  `start_date` date NULL DEFAULT NULL,
  `end_date` date NULL DEFAULT NULL,
  `types` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`contract_id`) USING BTREE,
  INDEX `FK_contracts_emp_file_id`(`emp_files_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `departments`  (
  `dept_id` int NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dept_manager` int NULL DEFAULT NULL,
  `location` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `emp_count` int NULL DEFAULT NULL,
  PRIMARY KEY (`dept_id`) USING BTREE,
  INDEX `FK_departments_dept_manager`(`dept_manager` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `edu_history`  (
  `edu_history_id` int NOT NULL AUTO_INCREMENT,
  `emp_files_id` int NULL DEFAULT NULL,
  `school_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `major` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `LEVEL` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `graduate_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`edu_history_id`) USING BTREE,
  INDEX `FK_Edu_History_emp_files_id`(`emp_files_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `emp_penalites`  (
  `emp_penality_id` int NOT NULL AUTO_INCREMENT,
  `emp_files_id` int NULL DEFAULT NULL,
  `TYPE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `reason` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `DATE` date NULL DEFAULT NULL,
  `amount` int NULL DEFAULT NULL,
  PRIMARY KEY (`emp_penality_id`) USING BTREE,
  INDEX `FK_Emp_Penalites_emp_files_id`(`emp_files_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `employee_attendance`  (
  `employee_Attendance_id` int NOT NULL AUTO_INCREMENT,
  `Leave_Record_id` int NULL DEFAULT NULL,
  `Leave_req_id` int NULL DEFAULT NULL,
  `OT_Record_id` int NULL DEFAULT NULL,
  `attendance_record_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`employee_Attendance_id`) USING BTREE,
  INDEX `FK_employee_Attendance_Leave_Record_id`(`Leave_Record_id` ASC) USING BTREE,
  INDEX `FK_employee_Attendance_Leave_req_id`(`Leave_req_id` ASC) USING BTREE,
  INDEX `FK_employee_attendance_OT_record_id`(`OT_Record_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `employee_awards`  (
  `Employee_Awards_id` int NOT NULL AUTO_INCREMENT,
  `Employee_Benefits_id` int NOT NULL,
  `Title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Reason` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `Amount` int NULL DEFAULT NULL,
  PRIMARY KEY (`Employee_Awards_id`) USING BTREE,
  INDEX `Employee_Benefits_id`(`Employee_Benefits_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `employee_benefits`  (
  `Employee_Benefits_id` int NOT NULL AUTO_INCREMENT,
  `medical_insurance` tinyint NULL DEFAULT NULL,
  `sick_leave` tinyint NULL DEFAULT NULL,
  `vision_insurance` tinyint NULL DEFAULT NULL,
  `maternity_leave` tinyint NULL DEFAULT NULL,
  PRIMARY KEY (`Employee_Benefits_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `employee_files`  (
  `emp_files_id` int NOT NULL AUTO_INCREMENT,
  `file_name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `file_size` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `file_path` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `upload_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`emp_files_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `employee_health_checkups`  (
  `Employee_Health_Checkups_id` int NOT NULL AUTO_INCREMENT,
  `emp_files_id` int NULL DEFAULT NULL,
  `Check_date` date NULL DEFAULT NULL,
  `height` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `weight` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `blood_pressure` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Employee_Health_Checkups_id`) USING BTREE,
  INDEX `FK_Employee_Health_Checkups_emp_files_id`(`emp_files_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `employee_performance_and_development`  (
  `emp_pnd_id` int NOT NULL AUTO_INCREMENT,
  `skillset_id` int NULL DEFAULT NULL,
  `employee_promotion_id` int NULL DEFAULT NULL,
  `emp_training_id` int NULL DEFAULT NULL,
  `credit_score` int NULL DEFAULT NULL,
  `credit_score_grader_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`emp_pnd_id`) USING BTREE,
  INDEX `skillset_id`(`skillset_id` ASC) USING BTREE,
  INDEX `employee_promotion_id`(`employee_promotion_id` ASC) USING BTREE,
  INDEX `emp_training_id`(`emp_training_id` ASC) USING BTREE,
  INDEX `credit_score_grader_id`(`credit_score_grader_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `employee_promotion`  (
  `emp_promo_id` int NOT NULL AUTO_INCREMENT,
  `promo_reason` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `current_position_id` int NOT NULL,
  `promoted_position_id` int NOT NULL,
  `promoted_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`emp_promo_id`) USING BTREE,
  INDEX `current_position_id`(`current_position_id` ASC) USING BTREE,
  INDEX `promoted_position_id`(`promoted_position_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `employee_training`  (
  `emp_training_id` int NOT NULL AUTO_INCREMENT,
  `training_skill_id` int NULL DEFAULT NULL,
  `trainer_id` int NULL DEFAULT NULL,
  `training_date` date NULL DEFAULT NULL,
  `training_duration` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`emp_training_id`) USING BTREE,
  INDEX `training_skill_id`(`training_skill_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `employees`  (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `birth_date` date NULL DEFAULT NULL,
  `phone_no` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dept_id` int NULL DEFAULT NULL,
  `position_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`emp_id`) USING BTREE,
  INDEX `FK_EMPLOYEES_DEPT_ID`(`dept_id` ASC) USING BTREE,
  INDEX `FK_EMPLOYEES_POSITION_ID`(`position_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `employees_salary_details`  (
  `sal_detail_id` int NOT NULL AUTO_INCREMENT,
  `Employee_Benefits_id` int NOT NULL,
  `BASE_SALARY` decimal(10, 2) NULL DEFAULT NULL,
  `BONUS` decimal(10, 2) NULL DEFAULT NULL,
  `ALLOWANCE` decimal(10, 2) NULL DEFAULT NULL,
  `DEDUCTIONS` decimal(10, 2) NULL DEFAULT NULL,
  `BENEFITS` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`sal_detail_id`) USING BTREE,
  INDEX `FK_EMPLOYEES_SALARY_DETAILS_Employee_Benefits_id`(`Employee_Benefits_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `interview_list`  (
  `Interview_list_id` int NOT NULL AUTO_INCREMENT,
  `Candidate_id` int NOT NULL,
  `Interviewer_id` int NOT NULL,
  `Interview_date` date NULL DEFAULT NULL,
  `Interview_result` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Interview_list_id`) USING BTREE,
  INDEX `FK_Interview_List_Candidate_id`(`Candidate_id` ASC) USING BTREE,
  INDEX `FK_Interview_List_Interviewer_id`(`Interviewer_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `leave_record`  (
  `leave_record_id` int NOT NULL AUTO_INCREMENT,
  `leave_req_id` int NULL DEFAULT NULL,
  `leave_start_date` date NULL DEFAULT NULL,
  `leave_end_date` date NULL DEFAULT NULL,
  `leave_approver_id` int NOT NULL,
  PRIMARY KEY (`leave_record_id`) USING BTREE,
  INDEX `FK_Leave_Record_leave_req_id`(`leave_req_id` ASC) USING BTREE,
  INDEX `FK_Leave_Record_leave_approver_id`(`leave_approver_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `leave_request`  (
  `leave_req_id` int NOT NULL AUTO_INCREMENT,
  `requester_id` int NOT NULL,
  `req_reason` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `req_start_date` date NULL DEFAULT NULL,
  `req_end_date` date NULL DEFAULT NULL,
  `approve_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`leave_req_id`) USING BTREE,
  INDEX `FK_Leave_Request_requester_id`(`requester_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `ot_record`  (
  `OT_Record_id` int NOT NULL AUTO_INCREMENT,
  `record_date` date NULL DEFAULT NULL,
  `time_in` time NULL DEFAULT NULL,
  `time_out` time NULL DEFAULT NULL,
  `ot_hour` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`OT_Record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `position_application`  (
  `position_apply_id` int NOT NULL AUTO_INCREMENT,
  `emp_id` int NOT NULL,
  `current_position_id` int NOT NULL,
  `position_opening_id` int NOT NULL,
  `application_reason` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `skillset_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`position_apply_id`) USING BTREE,
  INDEX `emp_id`(`emp_id` ASC) USING BTREE,
  INDEX `current_position_id`(`current_position_id` ASC) USING BTREE,
  INDEX `position_opening_id`(`position_opening_id` ASC) USING BTREE,
  INDEX `skillset_id`(`skillset_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `position_opening`  (
  `Position_Opening_id` int NOT NULL AUTO_INCREMENT,
  `Position_id` int NULL DEFAULT NULL,
  `Dept_id` int NULL DEFAULT NULL,
  `Experience_Required` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Education_Required` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Position_Opening_id`) USING BTREE,
  INDEX `FK_position_Opening_Position_id`(`Position_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `positions`  (
  `position_id` int NOT NULL AUTO_INCREMENT,
  `position_name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `avg_salary` decimal(10, 2) NULL DEFAULT NULL,
  `dept_id` int NULL DEFAULT NULL,
  `emp_count` int NULL DEFAULT NULL,
  PRIMARY KEY (`position_id`) USING BTREE,
  INDEX `FK_POSITIONS_DEPT_ID`(`dept_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `project_participation`  (
  `project_participate_id` int NOT NULL AUTO_INCREMENT,
  `emp_pnd_id` int NULL DEFAULT NULL,
  `project_id` int NULL DEFAULT NULL,
  `comment` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `start_date` date NULL DEFAULT NULL,
  `end_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`project_participate_id`) USING BTREE,
  INDEX `emp_pnd_id`(`emp_pnd_id` ASC) USING BTREE,
  INDEX `FK_project_participation_project_id`(`project_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `projects`  (
  `project_id` int NOT NULL AUTO_INCREMENT,
  `project_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `leader_id` int NULL DEFAULT NULL,
  `start_date` date NULL DEFAULT NULL,
  `end_date` date NULL DEFAULT NULL,
  `comment` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`project_id`) USING BTREE,
  INDEX `leader_id`(`leader_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `resignations`  (
  `resign_emp_id` int NOT NULL AUTO_INCREMENT,
  `resign_reason` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `RESIGN_DATE` date NULL DEFAULT NULL,
  `related_contract_id` int NULL DEFAULT NULL,
  `exit_interviewer_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`resign_emp_id`) USING BTREE,
  INDEX `related_contract_id`(`related_contract_id` ASC) USING BTREE,
  INDEX `exit_interviewer_id`(`exit_interviewer_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `salary_history`  (
  `SAL_HISTORY_ID` int NOT NULL AUTO_INCREMENT,
  `Employee_Benefits_id` int NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `TOTAL_SALARY` decimal(10, 2) NULL DEFAULT NULL,
  `START_DATE` date NULL DEFAULT NULL,
  `END_DATE` date NULL DEFAULT NULL,
  PRIMARY KEY (`SAL_HISTORY_ID`) USING BTREE,
  INDEX `FK_SALARY_HISTORY_SALARY_DETAILS_Employee_Benefits_id`(`Employee_Benefits_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `skills`  (
  `Skill_id` int NOT NULL AUTO_INCREMENT,
  `Skill_name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dept_id` int NULL DEFAULT NULL,
  `skill_resources` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `skill_description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Skill_id`) USING BTREE,
  INDEX `dept_id`(`dept_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `skillset`  (
  `Skillset_id` int NOT NULL AUTO_INCREMENT,
  `emp_pnd_id` int NULL DEFAULT NULL,
  `candidate_id` int NULL DEFAULT NULL,
  `Skill_one_id` int NULL DEFAULT NULL,
  `Skill_two_id` int NULL DEFAULT NULL,
  `Skill_three_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`Skillset_id`) USING BTREE,
  INDEX `candidate_id`(`candidate_id` ASC) USING BTREE,
  INDEX `Skill_one_id`(`Skill_one_id` ASC) USING BTREE,
  INDEX `Skill_two_id`(`Skill_two_id` ASC) USING BTREE,
  INDEX `Skill_three_id`(`Skill_three_id` ASC) USING BTREE,
  INDEX `FK_Skillset_emp_pnd_id`(`emp_pnd_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


CREATE TABLE `users`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `emp_id` int NOT NULL,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `permission_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `creat_date` date NULL DEFAULT NULL,
  `last_update_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `emp_id`(`emp_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;


CREATE TABLE `work_exp`  (
  `work_exp_id` int NOT NULL AUTO_INCREMENT,
  `emp_files_id` int NULL DEFAULT NULL,
  `company_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `POSITION` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `start_date` date NULL DEFAULT NULL,
  `end_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`work_exp_id`) USING BTREE,
  INDEX `FK_Work_Exp_emp_files_id`(`emp_files_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;




-- ADD CONSTRAINT
ALTER TABLE `attendance_record` ADD CONSTRAINT `attendance_record_ibfk_1` FOREIGN KEY (`attendance_record_id`) REFERENCES `employee_attendance` (`employee_Attendance_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `attendance_record` ADD CONSTRAINT `FK_Attendance_Record_OT_Record_id` FOREIGN KEY (`OT_Record_id`) REFERENCES `ot_record` (`OT_Record_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `candidates` ADD CONSTRAINT `FK_CANDIDATES_POSITION_OPENING_ID` FOREIGN KEY (`position_Opening_id`) REFERENCES `position_opening` (`Position_Opening_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `contracts` ADD CONSTRAINT `FK_contracts_emp_file_id` FOREIGN KEY (`emp_files_id`) REFERENCES `employee_files` (`emp_files_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `edu_history` ADD CONSTRAINT `FK_Edu_History_emp_files_id` FOREIGN KEY (`emp_files_id`) REFERENCES `employee_files` (`emp_files_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `emp_penalites` ADD CONSTRAINT `FK_Emp_Penalites_emp_files_id` FOREIGN KEY (`emp_files_id`) REFERENCES `employee_files` (`emp_files_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employee_attendance` ADD CONSTRAINT `employee_attendance_ibfk_1` FOREIGN KEY (`employee_Attendance_id`) REFERENCES `employee_files` (`emp_files_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employee_attendance` ADD CONSTRAINT `FK_employee_Attendance_Leave_Record_id` FOREIGN KEY (`Leave_Record_id`) REFERENCES `leave_record` (`leave_record_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employee_attendance` ADD CONSTRAINT `FK_employee_Attendance_Leave_req_id` FOREIGN KEY (`Leave_req_id`) REFERENCES `leave_request` (`leave_req_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employee_awards` ADD CONSTRAINT `employee_awards_ibfk_1` FOREIGN KEY (`Employee_Benefits_id`) REFERENCES `employee_benefits` (`Employee_Benefits_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employee_benefits` ADD CONSTRAINT `employee_benefits_ibfk_1` FOREIGN KEY (`Employee_Benefits_id`) REFERENCES `employees` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employee_files` ADD CONSTRAINT `employee_files_ibfk_1` FOREIGN KEY (`emp_files_id`) REFERENCES `employees` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employee_health_checkups` ADD CONSTRAINT `FK_Employee_Health_Checkups_emp_files_id` FOREIGN KEY (`emp_files_id`) REFERENCES `employee_files` (`emp_files_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employee_performance_and_development` ADD CONSTRAINT `employee_performance_and_development_ibfk_1` FOREIGN KEY (`emp_pnd_id`) REFERENCES `employees` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employee_performance_and_development` ADD CONSTRAINT `employee_performance_and_development_ibfk_2` FOREIGN KEY (`skillset_id`) REFERENCES `skillset` (`Skillset_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employee_performance_and_development` ADD CONSTRAINT `employee_performance_and_development_ibfk_3` FOREIGN KEY (`employee_promotion_id`) REFERENCES `employee_promotion` (`emp_promo_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employee_performance_and_development` ADD CONSTRAINT `employee_performance_and_development_ibfk_4` FOREIGN KEY (`emp_training_id`) REFERENCES `employee_training` (`emp_training_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employee_performance_and_development` ADD CONSTRAINT `employee_performance_and_development_ibfk_5` FOREIGN KEY (`credit_score_grader_id`) REFERENCES `employee_performance_and_development` (`emp_pnd_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employee_promotion` ADD CONSTRAINT `employee_promotion_ibfk_1` FOREIGN KEY (`current_position_id`) REFERENCES `positions` (`position_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employee_promotion` ADD CONSTRAINT `employee_promotion_ibfk_2` FOREIGN KEY (`promoted_position_id`) REFERENCES `positions` (`position_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employee_promotion` ADD CONSTRAINT `FK_employee_promotion_emp_promo_id` FOREIGN KEY (`emp_promo_id`) REFERENCES `employee_performance_and_development` (`emp_pnd_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employee_training` ADD CONSTRAINT `employee_training_ibfk_1` FOREIGN KEY (`training_skill_id`) REFERENCES `skills` (`Skill_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employees` ADD CONSTRAINT `FK_EMPLOYEES_DEPT_ID` FOREIGN KEY (`dept_id`) REFERENCES `departments` (`dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employees` ADD CONSTRAINT `FK_EMPLOYEES_POSITION_ID` FOREIGN KEY (`position_id`) REFERENCES `positions` (`position_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `employees_salary_details` ADD CONSTRAINT `FK_EMPLOYEES_SALARY_DETAILS_Employee_Benefits_id` FOREIGN KEY (`Employee_Benefits_id`) REFERENCES `employee_benefits` (`Employee_Benefits_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `interview_list` ADD CONSTRAINT `FK_Interview_List_Candidate_id` FOREIGN KEY (`Candidate_id`) REFERENCES `candidates` (`Candidate_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `interview_list` ADD CONSTRAINT `FK_Interview_List_Interviewer_id` FOREIGN KEY (`Interviewer_id`) REFERENCES `employees` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `leave_record` ADD CONSTRAINT `FK_Leave_Record_leave_approver_id` FOREIGN KEY (`leave_approver_id`) REFERENCES `employees` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `leave_record` ADD CONSTRAINT `FK_Leave_Record_leave_req_id` FOREIGN KEY (`leave_req_id`) REFERENCES `leave_request` (`leave_req_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `leave_request` ADD CONSTRAINT `FK_Leave_Request_requester_id` FOREIGN KEY (`requester_id`) REFERENCES `employees` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `position_application` ADD CONSTRAINT `position_application_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `position_application` ADD CONSTRAINT `position_application_ibfk_2` FOREIGN KEY (`current_position_id`) REFERENCES `positions` (`position_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `position_application` ADD CONSTRAINT `position_application_ibfk_3` FOREIGN KEY (`position_opening_id`) REFERENCES `position_opening` (`Position_Opening_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `position_application` ADD CONSTRAINT `position_application_ibfk_4` FOREIGN KEY (`skillset_id`) REFERENCES `skillset` (`skillset_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `position_opening` ADD CONSTRAINT `FK_position_Opening_Position_id` FOREIGN KEY (`Position_id`) REFERENCES `positions` (`position_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `positions` ADD CONSTRAINT `FK_POSITIONS_DEPT_ID` FOREIGN KEY (`dept_id`) REFERENCES `departments` (`dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `project_participation` ADD CONSTRAINT `FK_project_participation_project_id` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `project_participation` ADD CONSTRAINT `project_participation_ibfk_1` FOREIGN KEY (`emp_pnd_id`) REFERENCES `employee_performance_and_development` (`emp_pnd_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `projects` ADD CONSTRAINT `projects_ibfk_1` FOREIGN KEY (`leader_id`) REFERENCES `employee_performance_and_development` (`emp_pnd_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `resignations` ADD CONSTRAINT `resignations_ibfk_1` FOREIGN KEY (`resign_emp_id`) REFERENCES `employee_files` (`emp_files_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `resignations` ADD CONSTRAINT `resignations_ibfk_2` FOREIGN KEY (`related_contract_id`) REFERENCES `contracts` (`contract_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `resignations` ADD CONSTRAINT `resignations_ibfk_3` FOREIGN KEY (`exit_interviewer_id`) REFERENCES `employees` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `salary_history` ADD CONSTRAINT `FK_SALARY_HISTORY_SALARY_DETAILS_Employee_Benefits_id` FOREIGN KEY (`Employee_Benefits_id`) REFERENCES `employee_benefits` (`Employee_Benefits_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `skills` ADD CONSTRAINT `skills_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `departments` (`dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `skillset` ADD CONSTRAINT `FK_Skillset_emp_pnd_id` FOREIGN KEY (`emp_pnd_id`) REFERENCES `employee_performance_and_development` (`emp_pnd_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `skillset` ADD CONSTRAINT `skillset_ibfk_1` FOREIGN KEY (`candidate_id`) REFERENCES `candidates` (`Candidate_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `skillset` ADD CONSTRAINT `skillset_ibfk_2` FOREIGN KEY (`Skill_one_id`) REFERENCES `skills` (`Skill_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `skillset` ADD CONSTRAINT `skillset_ibfk_3` FOREIGN KEY (`Skill_two_id`) REFERENCES `skills` (`Skill_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `skillset` ADD CONSTRAINT `skillset_ibfk_4` FOREIGN KEY (`Skill_three_id`) REFERENCES `skills` (`Skill_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `work_exp` ADD CONSTRAINT `FK_Work_Exp_emp_files_id` FOREIGN KEY (`emp_files_id`) REFERENCES `employee_files` (`emp_files_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;




-- INSERT DATA
-- INSERT DATA INTO TABLE positions
INSERT INTO positions (position_name, avg_salary, dept_id, emp_count) VALUES
('Sales Manager', 70000.00, NULL, 1),
('Sales Representative', 45000.00, NULL, 8),
('Sales Associate', 38000.00, NULL, 10),
('Sales Support Specialist', 42000.00, NULL, 4),
('IT Manager', 65000.00, NULL, 1),
('Software Engineer', 58000.00, NULL, 7),
('Systems Analyst', 52000.00, NULL, 5),
('IT Support Specialist', 42000.00, NULL, 6),
('HR Manager', 60000.00, NULL, 1),
('HR Assistant', 45000.00, NULL, 3),
('HR Specialist', 48000.00, NULL, 5),
('HR System Administrator', 40000.00, NULL, 4),
('Marketing Manager', 60000.00, NULL, 5),
('Marketing Specialist', 45000.00, NULL, 8),
('Social Media Manager', 50000.00, NULL, 3),
('Marketing Analyst', 55000.00, NULL, 6),
('Finance Manager', 62000.00, NULL, 1),
('Financial Analyst', 55000.00, NULL, 3),
('Accountant', 48000.00, NULL, 6),
('Auditor', 53000.00, NULL, 2);

-- INSERT DATA INTO TABLE departments
INSERT INTO departments(dept_name, dept_manager, location, emp_count) VALUES
		("Department of sale", NULL, "floor1", 10),
		("Department of information technology", NULL, "floor2", 9),
		("Department of Human Resources", NULL, "floor3", 5),
		("Department of Marketing", NULL, "floor4", 5),
		("Department of Finance", NULL, "floor5", 4);


-- INSERT DATA INTO TABLE employees
INSERT INTO employees (name, gender, birth_date, phone_no, dept_id, position_id) VALUES 
		('John Doe', 'Male', '1990-05-15', '011-12345678', 3, 9),
		('Jane Smith', 'Female', '1985-08-22', '012-98765432', 1, 1),
		('Michael Johnson', 'Male', '1988-11-30', '013-55555555', 2, 5),
		('Emily Brown', 'Female', '1992-03-25', '014-77777777', 4, 13),
		('David Lee', 'Male', '1987-09-18', '015-88888888', 5, 17),
		('Sarah Wang', 'Female', '1991-07-10', '016-99999999', 1, 3),
		('Robert Chen', 'Male', '1986-12-05', '017-66666666', 2, 7),
		('Jessica Liu', 'Female', '1989-04-12', '018-11111111', 3, 12),
		('William Zhang', 'Male', '1993-02-08', '019-22222222', 4, 16),
		('Linda Wu', 'Female', '1994-01-01', '010-44444444', 5, 20),
		('Alex Johnson', 'Male', '1992-08-11', '011-12345678', 1, 2),
		('Ella Williams', 'Female', '1990-05-22', '011-98765432', 2, 6),
		('Noah Smith', 'Male', '1988-11-19', '011-56789012', 1, 3),
		('Ava Davis', 'Female', '1995-03-25', '011-24681357', 3, 10),
		('Liam Taylor', 'Male', '1994-09-18', '011-11223344', 2, 7),
		('Mia Brown', 'Female', '1991-07-11', '011-55443322', 1, 4),
		('Jameson Lee', 'Male', '1989-12-29', '011-98761234', 3, 11),
		('Aria Wilson', 'Female', '1993-04-06', '011-66778899', 2, 8),
		('Ethan Miller', 'Male', '1996-06-30', '011-13579135', 1, 2),
		('Scarlett Martin', 'Female', '1987-02-14', '011-11235813', 3, 12);



-- UPDATE TABLE positions
UPDATE positions SET dept_id = 1 WHERE position_id BETWEEN 1 AND 4;
UPDATE positions SET dept_id = 2 WHERE position_id BETWEEN 5 AND 8;
UPDATE positions SET dept_id = 3 WHERE position_id BETWEEN 9 AND 12;
UPDATE positions SET dept_id = 4 WHERE position_id BETWEEN 13 AND 16;
UPDATE positions SET dept_id = 5 WHERE position_id BETWEEN 17 AND 20;


-- UPDATE TABLE departments
UPDATE departments SET dept_manager = 2 WHERE dept_id = 1;
UPDATE departments SET dept_manager = 3 WHERE dept_id = 2;
UPDATE departments SET dept_manager = 1 WHERE dept_id = 3;
UPDATE departments SET dept_manager = 4 WHERE dept_id = 4;
UPDATE departments SET dept_manager = 5 WHERE dept_id = 5;



-- INSERT DATA INTO TABLE employee_files
INSERT INTO employee_files (file_name, file_size, file_path, upload_date) VALUES 
		('Resume_John_Doe.pdf', '2.3 MB', '/uploads/resumes/', '2023-05-10'),
		('Profile_Picture_Jane_Smith.jpg', '300 KB', '/uploads/pictures/', '2023-05-11'),
		('Performance_Review_James_Brown.docx', '1.8 MB', '/uploads/reviews/', '2023-05-12'),
		('Contract_Annexure_Alice_Johnson.pdf', '800 KB', '/uploads/contracts/', '2023-05-13'),
		('Training_Certificate_Robert_Lee.pdf', '1.5 MB', '/uploads/certificates/', '2023-05-14'),
		('Promotion_Letter_Susan_Wilson.pdf', '1.2 MB', '/uploads/letters/', '2023-05-15'),
		('Offer_Letter_Michael_Chen.pdf', '900 KB', '/uploads/offers/', '2023-05-16'),
		('Resignation_Letter_Linda_Wang.pdf', '700 KB', '/uploads/resignations/', '2023-05-17'),
		('Leave_Application_Kevin_Lin.pdf', '600 KB', '/uploads/leave/', '2023-05-18'),
		('Training_Plan_Mary_Lee.docx', '2.0 MB', '/uploads/training/', '2023-05-19');


-- INSERT DATA INTO TABLE work_exp
INSERT INTO work_exp (emp_files_id, company_name, POSITION, start_date, end_date) VALUES 
		(1, 'ABC Corporation', 'Software Engineer', '2020-01-05', '2021-02-28'),
		(2, 'XYZ Tech', 'Web Developer', '2019-03-15', '2020-12-31'),
		(3, 'Acme Solutions', 'Project Manager', '2018-06-10', '2019-12-15'),
		(4, 'Tech Innovators', 'Data Analyst', '2022-03-01', '2022-08-31'),
		(5, 'Global Industries', 'Marketing Specialist', '2021-05-20', '2022-03-10'),
		(6, 'Software Solutions', 'Software Developer', '2020-08-10', '2021-11-30'),
		(7, 'Innovative Tech', 'Systems Administrator', '2019-02-15', '2020-05-31'),
		(8, 'Tech Solutions', 'Network Engineer', '2022-01-01', '2022-09-30'),
		(9, 'Data Systems', 'Database Administrator', '2017-09-12', '2019-01-15'),
		(10, 'Digital Marketing Co.', 'Marketing Manager', '2021-03-05', '2022-06-30');


-- INSERT DATA INTO TABLE employee_health_checkups
INSERT INTO employee_health_checkups (emp_files_id, Check_date, height, weight, blood_pressure) VALUES 
		(1, '2022-05-15', '170 cm', '65 kg', '120/80 mmHg'),
		(2, '2021-12-30', '165 cm', '55 kg', '110/70 mmHg'),
		(3, '2023-02-20', '175 cm', '75 kg', '130/85 mmHg'),
		(4, '2022-08-10', '160 cm', '50 kg', '115/75 mmHg'),
		(5, '2021-06-25', '180 cm', '85 kg', '140/90 mmHg'),
		(6, '2023-01-05', '172 cm', '70 kg', '125/80 mmHg'),
		(7, '2022-03-12', '168 cm', '60 kg', '118/78 mmHg'),
		(8, '2021-11-18', '178 cm', '80 kg', '135/85 mmHg'),
		(9, '2022-01-30', '162 cm', '53 kg', '112/72 mmHg'),
		(10, '2023-04-05', '185 cm', '90 kg', '145/95 mmHg');


-- INSERT DATA INTO TABLE emp_penalites
INSERT INTO emp_penalites (emp_files_id, TYPE, reason, DATE, amount) VALUES 
		(1, 'Fine', 'Late to work', '2022-05-15', 100),
		(2, 'Deduction', 'Violation of company policy', '2021-12-30', 200),
		(3, 'Warning', 'Unprofessional behavior', '2023-02-20', NULL),
		(4, 'Fine', 'Unauthorized absence', '2022-08-10', 150),
		(5, 'Deduction', 'Misuse of company resources', '2021-06-25', 300),
		(6, 'Warning', 'Failure to meet performance targets', '2023-01-05', NULL),
		(7, 'Fine', 'Violation of safety protocols', '2022-03-12', 120),
		(8, 'Deduction', 'Breach of confidentiality', '2021-11-18', 250),
		(9, 'Warning', 'Poor time management', '2022-01-30', NULL),
		(10, 'Fine', 'Insubordination', '2023-04-05', 180);


-- INSERT DATA INTO TABLE edu_history
INSERT INTO edu_history (emp_files_id, school_name, major, LEVEL, graduate_date) VALUES 
		(1, 'ABC University', 'Computer Science', 'Bachelor', '2021-06-30'),
		(2, 'XYZ College', 'Business Administration', 'Master', '2020-12-15'),
		(3, '123 School of Engineering', 'Mechanical Engineering', 'Bachelor', '2022-05-20'),
		(4, 'DEF Institute', 'Finance', 'Bachelor', '2019-09-10'),
		(5, 'LMN College', 'Marketing', 'Master', '2023-03-25'),
		(6, '456 University', 'Electrical Engineering', 'Bachelor', '2022-01-05'),
		(7, 'GHI College', 'Human Resources', 'Master', '2021-07-12'),
		(8, 'UVW School of Medicine', 'Medicine', 'Doctorate', '2020-11-18'),
		(9, 'PQR Institute of Technology', 'Information Technology', 'Bachelor', '2023-01-30'),
		(10, 'JKL College', 'Psychology', 'Master', '2022-04-05');


-- INSERT DATA INTO TABLE contracts
INSERT INTO contracts (emp_files_id, start_date, end_date, types, status) VALUES 
		(1, '2021-06-01', '2023-05-31', 'Full-time', 'Active'),
		(2, '2020-12-15', '2022-12-14', 'Part-time', 'Active'),
		(3, '2022-03-10', '2024-03-09', 'Contractor', 'Active'),
		(4, '2019-09-01', '2022-08-31', 'Full-time', 'Inactive'),
		(5, '2023-01-15', '2023-07-14', 'Internship', 'Active'),
		(6, '2022-08-20', '2023-08-19', 'Part-time', 'Active'),
		(7, '2021-07-01', '2023-06-30', 'Full-time', 'Active'),
		(8, '2020-11-01', '2021-10-31', 'Contractor', 'Inactive'),
		(9, '2023-02-05', '2024-02-04', 'Full-time', 'Active'),
		(10, '2022-04-10', '2023-04-09', 'Internship', 'Active');


-- INSERT DATA INTO TABLE resignations
INSERT INTO resignations (resign_emp_id, resign_reason, RESIGN_DATE, related_contract_id, exit_interviewer_id) VALUES 
		(1, 'Personal reasons', '2023-05-15', 1, 5),
		(2, 'Found a new opportunity', '2023-06-30', 2, 8),
		(3, 'Relocating to another city', '2023-07-20', 3, 6),
		(4, 'Health issues', '2023-08-10', 4, 3),
		(5, 'Career change', '2023-09-05', 5, 7),
		(6, 'Retirement', '2023-10-15', 6, 2),
		(7, 'Family reasons', '2023-11-25', 7, 4),
		(8, 'Pursuing higher education', '2023-12-20', 8, 9),
		(9, 'Contract completion', '2023-12-31', 9, 1),
		(10, 'Unsatisfactory work environment', '2024-01-15', 10, 7);


-- INSERT DATA INTO TABLE employee_attendance
INSERT INTO employee_attendance (employee_attendance_id) VALUES 
		(1), (2), (3), (4), (5), (6), (7), (8), (9), (10);


-- INSERT DATA INTO TABLE ot_record
INSERT INTO ot_record (record_date, time_in, time_out, ot_hour) VALUES 
		('2023-05-01', '08:30:00', '17:30:00', 9.00),
		('2023-05-02', '09:00:00', '18:00:00', 8.00),
		('2023-05-03', '08:00:00', '17:00:00', 0.00),
		('2023-05-04', '10:00:00', '19:00:00', 9.00),
		('2023-05-05', '09:30:00', '18:30:00', 9.00),
		('2023-05-06', '08:45:00', '18:45:00', 10.00),
		('2023-05-07', '09:15:00', '19:15:00', 10.00),
		('2023-05-08', '08:30:00', '17:30:00', 9.00),
		('2023-05-09', '09:00:00', '18:00:00', 8.00),
		('2023-05-10', '08:00:00', '17:00:00', 0.00);


-- INSERT DATA INTO TABLE attendance_record
INSERT INTO attendance_record (record_date, time_in, time_out, OT_Record_id) VALUES 
		('2023-05-01', '08:30:00', '17:30:00', 1),
		('2023-05-02', '09:00:00', '18:00:00', 2),
		('2023-05-03', '08:00:00', '17:00:00', 3),
		('2023-05-04', '10:00:00', '19:00:00', 4),
		('2023-05-05', '09:30:00', '18:30:00', 5),
		('2023-05-06', '08:45:00', '18:45:00', 6),
		('2023-05-07', '09:15:00', '19:15:00', 7),
		('2023-05-08', '08:30:00', '17:30:00', 8),
		('2023-05-09', '09:00:00', '18:00:00', 9),
		('2023-05-10', '08:00:00', '17:00:00', 10);


-- INSERT DATA INTO TABLE leave_request
INSERT INTO leave_request (requester_id, req_reason, req_start_date, req_end_date, approve_status) VALUES 
		(1, 'Vacation', '2023-05-15', '2023-05-18', 'Pending'),
		(2, 'Sick Leave', '2023-05-20', '2023-05-22', 'Approved'),
		(3, 'Family Emergency', '2023-05-10', '2023-05-11', 'Approved'),
		(4, 'Personal Leave', '2023-05-25', '2023-05-25', 'Pending'),
		(5, 'Vacation', '2023-05-12', '2023-05-14', 'Approved'),
		(6, 'Sick Leave', '2023-05-30', '2023-05-31', 'Pending'),
		(7, 'Vacation', '2023-05-23', '2023-05-25', 'Approved'),
		(8, 'Personal Leave', '2023-05-05', '2023-05-06', 'Approved'),
		(9, 'Sick Leave', '2023-05-02', '2023-05-03', 'Approved'),
		(10, 'Family Emergency', '2023-05-28', '2023-05-29', 'Pending');


-- INSERT DATA INTO TABLE leave_record
INSERT INTO leave_record (leave_req_id, leave_start_date, leave_end_date, leave_approver_id) VALUES 
		(1, '2023-05-15', '2023-05-18', 1),
		(2, '2023-05-20', '2023-05-22', 2),
		(3, '2023-05-10', '2023-05-11', 3),
		(4, '2023-05-25', '2023-05-25', 4),
		(5, '2023-05-12', '2023-05-14', 5),
		(6, '2023-05-30', '2023-05-31', 6),
		(7, '2023-05-23', '2023-05-25', 7),
		(8, '2023-05-05', '2023-05-06', 8),
		(9, '2023-05-02', '2023-05-03', 9),
		(10, '2023-05-28', '2023-05-29', 10);


-- INSERT DATA INTO TABLE position_opening
INSERT INTO position_opening (Position_id, Dept_id, Experience_Required, Education_Required) VALUES 
		(1, 1, '2-4 years of relevant experience', 'Bachelor\'s degree in Computer Science'),
		(2, 2, '5+ years of experience in marketing', 'Bachelor\'s degree in Marketing or related field'),
		(3, 3, '3-5 years of experience in finance', 'Bachelor\'s degree in Finance or Accounting'),
		(4, 4, '2-3 years of experience in customer service', 'High school diploma or equivalent'),
		(5, 5, '4-6 years of experience in sales', 'Bachelor\'s degree in Business or a related field'),
		(6, 1, '3+ years of experience in project management', 'Bachelor\'s degree in Project Management or a related field'),
		(7, 2, '5-7 years of experience in human resources', 'Bachelor\'s degree in Human Resources or a related field'),
		(8, 3, '2-4 years of experience in software development', 'Bachelor\'s degree in Computer Science or Software Engineering'),
		(9, 4, '1-2 years of experience in data analysis', 'Bachelor\'s degree in Data Science or a related field'),
		(10, 5, '6+ years of experience in leadership', 'Bachelor\'s degree in Business Administration or a related field');


-- INSERT DATA INTO TABLE employee_benefits
INSERT INTO employee_benefits (medical_insurance, sick_leave, vision_insurance, maternity_leave) VALUES
		(1, 1, 0, 1),
		(0, 1, 1, 0),
		(1, 1, 1, 1),
		(1, 0, 0, 1),
		(1, 1, 0, 0),
		(0, 1, 1, 1),
		(1, 0, 1, 1),
		(1, 1, 1, 0),
		(0, 0, 1, 1),
		(1, 1, 0, 1);


-- INSERT DATA INTO TABLE employee_awards
INSERT INTO employee_awards (Employee_Benefits_id, Title, Reason, date, Amount) VALUES
		(1, 'Outstanding Performance Award', 'Exceeded sales targets for Q1', '2023-04-15', 1000),
		(2, 'Team Collaboration Award', 'Contributed significantly to a successful project', '2023-03-22', 800),
		(3, 'Innovation Excellence Award', 'Introduced a new cost-saving process', '2023-04-05', 1200),
		(4, 'Leadership Achievement Award', 'Successfully led a cross-functional team', '2023-02-10', 1500),
		(5, 'Customer Service Award', 'Received outstanding customer feedback', '2023-05-02', 600),
		(1, 'Employee of the Month', 'Consistently high performance and dedication', '2023-04-30', 500),
		(3, 'Quality Improvement Award', 'Improved product quality and customer satisfaction', '2023-03-18', 1000),
		(2, 'Excellence in Problem-Solving', 'Resolved a critical issue with efficiency', '2023-05-08', 700),
		(4, 'Inspirational Leadership Award', 'Motivated team members to achieve their best', '2023-02-28', 900),
		(5, 'Safety Champion Award', 'Promoted a culture of safety in the workplace', '2023-04-20', 800);


-- INSERT DATA INTO TABLE employees_salary_details
INSERT INTO employees_salary_details (Employee_Benefits_id, BASE_SALARY, BONUS, ALLOWANCE, DEDUCTIONS, BENEFITS) VALUES
		(1, 5000.00, 1000.00, 500.00, 200.00, 300.00),
		(2, 4800.00, 800.00, 450.00, 180.00, 280.00),
		(3, 5200.00, 1200.00, 600.00, 250.00, 320.00),
		(4, 5500.00, 1500.00, 700.00, 280.00, 350.00),
		(5, 4700.00, 750.00, 400.00, 150.00, 240.00),
		(1, 4900.00, 900.00, 480.00, 190.00, 290.00),
		(3, 5100.00, 1100.00, 580.00, 230.00, 310.00),
		(2, 4600.00, 700.00, 420.00, 160.00, 260.00),
		(4, 5300.00, 1400.00, 650.00, 270.00, 330.00),
		(5, 4800.00, 800.00, 450.00, 180.00, 280.00);


-- INSERT DATA INTO TABLE salary_history
INSERT INTO salary_history (Employee_Benefits_id, gender, TOTAL_SALARY, START_DATE, END_DATE) VALUES
		(1, 'Male', 5500.00, '2023-01-01', '2023-01-31'),
		(2, 'Female', 5200.00, '2023-01-01', '2023-01-31'),
		(3, 'Male', 5800.00, '2023-01-01', '2023-01-31'),
		(4, 'Female', 6100.00, '2023-01-01', '2023-01-31'),
		(5, 'Male', 5300.00, '2023-01-01', '2023-01-31'),
		(1, 'Female', 5400.00, '2023-02-01', '2023-02-28'),
		(3, 'Male', 6000.00, '2023-02-01', '2023-02-28'),
		(2, 'Male', 5000.00, '2023-02-01', '2023-02-28'),
		(4, 'Female', 6200.00, '2023-02-01', '2023-02-28'),
		(5, 'Male', 5500.00, '2023-02-01', '2023-02-28');


-- INSERT DATA INTO TABLE skills
INSERT INTO skills (Skill_name, dept_id, skill_resources, skill_description) VALUES
		-- skills that matched Department of Sale
		('Sales Techniques', 1, 'Sales training materials', 'Techniques to improve sales performance'),
		('Negotiation Skills', 1, 'Negotiation workshops', 'Skills for effective negotiation'),
		('Customer Relationship Management', 1, 'CRM software', 'Managing customer relationships effectively'),
		('Presentation Skills', 1, 'Presentation workshops', 'Improving presentation and communication skills'),

		-- skills that matched Department of Information Technology
		('Java', 2, 'Online Java tutorials', 'Java programming language'),
		('Python', 2, 'Python IDEs', 'Python programming language'),
		('Web Development', 2, 'Web development resources', 'Skills for building web applications'),
		('Database Management', 2, 'Database management tools', 'Managing and optimizing databases'),

		-- skills that matched Department of Human Resources
		('Recruitment and Selection', 3, 'Recruitment guidelines', 'Best practices for hiring and selection'),
		('Performance Management', 3, 'Performance appraisal tools', 'Managing employee performance'),
		('Training and Development', 3, 'Training modules', 'Developing employee skills through training'),
		('Employee Relations', 3, 'Employee relation resources', 'Managing employee relations and conflicts'),

		-- skills that matched Department of Marketing
		('Digital Marketing', 4, 'Online marketing platforms', 'Skills for digital marketing campaigns'),
		('Market Research', 4, 'Market research tools', 'Conducting market research and analysis'),
		('Brand Management', 4, 'Brand management guides', 'Managing and building brand identity'),
		('Social Media Marketing', 4, 'Social media marketing resources', 'Utilizing social media for marketing'),

		-- skills that matched Department of Finance
		('Financial Analysis', 5, 'Financial analysis software', 'Analyzing financial data and reports'),
		('Budgeting and Forecasting', 5, 'Budgeting tools', 'Creating budgets and financial forecasts'),
		('Taxation', 5, 'Taxation guidelines', 'Understanding and complying with taxation laws'),
		('Risk Management', 5, 'Risk management strategies', 'Identifying and managing financial risks');


-- INSERT DATA INTO TABLE  candidates
INSERT INTO `candidates` (`Candidate_name`, `Email`, `phone_no`, `Skill_set_id`, `position_Opening_id`) VALUES
		('Emily Turner', 'emily.turner@example.com', '020-11111111', 12, 6),
		('Jacob Parker', 'jacob.parker@example.com', '021-22222222', 13, 8),
		('Olivia Mitchell', 'olivia.mitchell@example.com', '022-33333333', 14, 2),
		('Michael Scott', 'michael.scott@example.com', '023-44444444', 15, 4),
		('Sophia Young', 'sophia.young@example.com', '024-55555555', 16, 9),
		('William Allen', 'william.allen@example.com', '025-66666666', 19, 5),
		('Emma Hill', 'emma.hill@example.com', '026-77777777', 20, 10),
		('Noah Turner', 'noah.turner@example.com', '027-88888888', 11, 3),
		('Ava Reed', 'ava.reed@example.com', '028-99999999', 6, 7),
		('James Evans', 'james.evans@example.com', '029-00000000', 8, 2);


-- INSERT DATA INTO TABLE  skillset
INSERT INTO skillset (emp_pnd_id, candidate_id, Skill_one_id, Skill_two_id, Skill_three_id) VALUES
		(NULL, NULL, 2, 3, 6),
		(NULL, NULL, 8, 9, 11),
		(NULL, NULL, 14, 15, 17),
		(NULL, NULL, 19, 20, 4),
		(NULL, NULL, 10, 12, 18),
		(NULL, 1, 3, 5, 7),
		(NULL, 2, 9, 13, 16),
		(NULL, 3, 17, 6, 12),
		(NULL, 4, 8, 10, 15),
		(NULL, 5, 2, 4, 20);



ALTER TABLE position_application AUTO_INCREMENT = 1;
-- INSERT DATA INTO TABLE  position_application
INSERT INTO `position_application` (`emp_id`, `current_position_id`, `position_opening_id`, `application_reason`, `skillset_id`) VALUES
		(1, 3, 8, 'I am interested in this new position', 7),
		(2, 2, 5, 'I believe I have the required skills', 5),
		(3, 4, 9, 'I want to take on new challenges', 10),
		(4, 1, 4, 'I have relevant experience in this area', 2),
		(5, 3, 7, 'I see this as an opportunity for growth', 8),
		(6, 2, 5, 'I am passionate about this role', 6),
		(7, 4, 10, 'I am excited about the company culture', 3),
		(8, 1, 3, 'I am looking for a new opportunity', 1),
		(9, 3, 6, 'I want to contribute to the team', 9),
		(10, 2, 2, 'I am ready to take on more responsibility', 4);


-- INSERT DATA INTO TABLE  interview_list
INSERT INTO interview_list (Candidate_id, Interviewer_id, Interview_date, Interview_result) VALUES
		(1, 5, '2023-05-01', 'Impressed with candidate\'s technical skills and problem-solving ability.'),
		(2, 3, '2023-05-02', 'Candidate demonstrated excellent communication and teamwork.'),
		(3, 1, '2023-05-03', 'Candidate has relevant experience and a strong work ethic.'),
		(4, 4, '2023-05-04', 'Interviewer recommended the candidate for further consideration.'),
		(5, 2, '2023-05-05', 'Candidate showed a proactive attitude and willingness to learn.'),
		(6, 6, '2023-05-06', 'Interviewer was impressed with the candidate\'s leadership potential.'),
		(7, 7, '2023-05-07', 'Candidate displayed a deep understanding of the industry.'),
		(8, 9, '2023-05-08', 'Interviewer noted the candidate\'s attention to detail and accuracy.'),
		(9, 12, '2023-05-09', 'Candidate demonstrated strong problem-solving skills.'),
		(10, 8, '2023-05-10', 'Interviewer was pleased with the candidate\'s passion for the role.');


-- INSERT DATA INTO TABLE  employee_training
INSERT INTO `employee_training` (`training_skill_id`, `trainer_id`, `training_date`, `training_duration`) VALUES
		(1, 4, '2023-05-01', '3 days'),
		(2, 4, '2023-05-02', '2 days'),
		(3, 4, '2023-05-03', '1 day'),
		(4, 4, '2023-05-04', '4 days'),
		(5, 8, '2023-05-05', '5 days'),
		(1, 4, '2023-05-06', '2 days'),
		(2, 8, '2023-05-07', '3 days'),
		(3, 8, '2023-05-08', '4 days'),
		(4, 8, '2023-05-09', '1 day'),
		(5, 8, '2023-05-10', '2 days');



ALTER TABLE employee_performance_and_development AUTO_INCREMENT = 1;
-- INSERT DATA INTO TABLE  employee_performance_and_development
INSERT INTO `employee_performance_and_development` (`skillset_id`, `employee_promotion_id`, `emp_training_id`, `credit_score`, `credit_score_grader_id`) VALUES
		(1, NULL, 1, 85, NULL),
		(2, NULL, 2, 78, NULL),
		(3, NULL, 3, 92, NULL),
		(4, NULL, 4, 79, NULL),
		(5, NULL, 5, 88, NULL),
		(1, NULL, 6, 95, NULL),
		(2, NULL, 7, 82, NULL),
		(3, NULL, 8, 90, NULL),
		(4, NULL, 9, 75, NULL),
		(5, NULL, 10, 87, NULL);


-- INSERT DATA INTO TABLE  employee_promotion
INSERT INTO employee_promotion (promo_reason, current_position_id, promoted_position_id, promoted_date) VALUES
		('Excellent performance and leadership skills', 3, 8, '2023-03-15'),
		('Completed advanced training program', 5, 10, '2023-02-28'),
		('Consistent high-quality work', 2, 6, '2023-04-10'),
		('Outstanding teamwork and problem-solving', 4, 9, '2023-03-05'),
		('Demonstrated exceptional customer service', 6, 12, '2023-04-20'),
		('Achieved remarkable sales performance', 7, 13, '2023-03-22'),
		('Strong dedication and commitment', 1, 4, '2023-02-12'),
		('Leadership skills and team management', 9, 15, '2023-03-18'),
		('Innovative ideas and project management', 8, 14, '2023-02-25'),
		('Exemplary communication and problem-solving', 10, 16, '2023-04-05');


-- INSERT DATA INTO TABLE projects
INSERT INTO projects (project_title, leader_id, start_date, end_date, comment) VALUES
		('Sales Performance Analysis', 2, '2023-06-10', '2023-08-20', 'Analyzing sales data for improvement'),
		('IT System Upgrade', 3, '2023-07-15', '2023-09-25', 'Enhancing technology infrastructure'),
		('Employee Training Initiative', 1, '2023-05-05', '2023-07-15', 'Enhancing employee skills'),
		('Marketing Campaign Launch', 4, '2023-06-25', '2023-09-05', 'Launching new marketing campaign'),
		('Financial Data Management', 5, '2023-07-01', '2023-09-30', 'Optimizing financial data handling'),
		('Sales Team Performance Evaluation', 2, '2023-08-05', '2023-10-15', 'Assessing sales team effectiveness'),
		('IT Security Enhancement', 3, '2023-06-15', '2023-08-30', 'Improving IT security measures'),
		('Talent Acquisition Strategy', 1, '2023-07-20', '2023-10-10', 'Developing talent acquisition plan'),
		('Product Marketing Research', 4, '2023-05-20', '2023-07-30', 'Conducting market research for products'),
		('Financial Forecasting Project', 5, '2023-08-15', '2023-11-05', 'Forecasting financial trends');


-- INSERT DATA INTO TABLE project_participation
INSERT INTO project_participation (emp_pnd_id, project_id, comment, start_date, end_date) VALUES
		(1, 1, 'Assisting in sales analysis', '2023-06-10', '2023-08-20'),
		(2, 3, 'Working on IT system upgrade', '2023-07-15', '2023-09-25'),
		(3, 2, 'Participating in employee training', '2023-05-05', '2023-07-15'),
		(4, 4, 'Contributing to marketing campaign', '2023-06-25', '2023-09-05'),
		(5, 5, 'Supporting financial data management', '2023-07-01', '2023-09-30'),
		(1, 2, 'Evaluating sales team performance', '2023-08-05', '2023-10-15'),
		(2, 3, 'Assisting in IT security enhancement', '2023-06-15', '2023-08-30'),
		(3, 1, 'Participating in talent acquisition strategy', '2023-07-20', '2023-10-10'),
		(4, 4, 'Conducting product marketing research', '2023-05-20', '2023-07-30'),
		(5, 5, 'Contributing to financial forecasting', '2023-08-15', '2023-11-05');


-- INSERT DATA INTO TABLE users
INSERT INTO users (emp_id, username, password, permission_type, description, creat_date, last_update_date) VALUES
		(1, 'john_doe_9257', '19900515', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-01', '2023-05-01'),
		(2, 'jane_smith_9257', '19850822', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-02', '2023-05-02'),
		(3, 'michael_johnson_9257', '19881130', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-03', '2023-05-03'),
		(4, 'emily_brown_9257', '19920325', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-04', '2023-05-04'),
		(5, 'david_lee_9257', '19870918', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-05', '2023-05-05'),
		(6, 'sarah_wang_9257', '19910710', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-06', '2023-05-06'),
		(7, 'robert_chen_9257', '19861205', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-07', '2023-05-07'),
		(8, 'jessica_liu_9257', '19890412', 'administrator', 'Users with this permission can add, delete, modify and query all tables and data.', '2023-05-08', '2023-05-08'),
		(9, 'william_zhang_9257', '19930208', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-09', '2023-05-09'),
		(10, 'linda_wu_9257', '19940101', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-10', '2023-05-10'),
		(11, 'alex_johnson_9257', '19920811', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-11', '2023-05-11'),
		(12, 'ella_williams_9257', '19900522', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-12', '2023-05-12'),
		(13, 'noah_smith_9257', '19881119', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-13', '2023-05-13'),
		(14, 'ava_davis_9257', '19950325', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-14', '2023-05-14'),
		(15, 'liam_taylor_9257', '19940918', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-15', '2023-05-15'),
		(16, 'mia_brown_9257', '19910711', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-16', '2023-05-16'),
		(17, 'jameson_lee_9257', '19891229', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-17', '2023-05-17'),
		(18, 'aria_wilson_9257', '19930406', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-18', '2023-05-18'),
		(19, 'ethan_miller_9257', '19960630', 'general', 'Users with this permission can only view and modify their basic personal information.', '2023-05-19', '2023-05-19'),
		(20, 'scarlett_martin_9257', '19870214', 'administrator', 'Users with this permission can add, delete, modify and query all tables and data.', '2023-05-20', '2023-05-20');


-- UPDATE TABLE
-- employee_attendance
UPDATE `employee_attendance` SET
  `Leave_Record_id` = 10,
  `Leave_req_id` = 8,
  `OT_Record_id` = 6,
  `attendance_record_id` = 4
WHERE `employee_Attendance_id` = 1;

UPDATE `employee_attendance` SET
  `Leave_Record_id` = 9,
  `Leave_req_id` = 7,
  `OT_Record_id` = 5,
  `attendance_record_id` = 3
WHERE `employee_Attendance_id` = 2;

UPDATE `employee_attendance` SET
  `Leave_Record_id` = 8,
  `Leave_req_id` = 6,
  `OT_Record_id` = 4,
  `attendance_record_id` = 2
WHERE `employee_Attendance_id` = 3;

UPDATE `employee_attendance` SET
  `Leave_Record_id` = 7,
  `Leave_req_id` = 5,
  `OT_Record_id` = 3,
  `attendance_record_id` = 1
WHERE `employee_Attendance_id` = 4;

UPDATE `employee_attendance` SET
  `Leave_Record_id` = 6,
  `Leave_req_id` = 4,
  `OT_Record_id` = 2,
  `attendance_record_id` = 10
WHERE `employee_Attendance_id` = 5;

UPDATE `employee_attendance` SET
  `Leave_Record_id` = 5,
  `Leave_req_id` = 3,
  `OT_Record_id` = 1,
  `attendance_record_id` = 9
WHERE `employee_Attendance_id` = 6;

UPDATE `employee_attendance` SET
  `Leave_Record_id` = 4,
  `Leave_req_id` = 2,
  `OT_Record_id` = 10,
  `attendance_record_id` = 8
WHERE `employee_Attendance_id` = 7;

UPDATE `employee_attendance` SET
  `Leave_Record_id` = 3,
  `Leave_req_id` = 1,
  `OT_Record_id` = 9,
  `attendance_record_id` = 7
WHERE `employee_Attendance_id` = 8;

UPDATE `employee_attendance` SET
  `Leave_Record_id` = 2,
  `Leave_req_id` = 10,
  `OT_Record_id` = 8,
  `attendance_record_id` = 6
WHERE `employee_Attendance_id` = 9;

UPDATE `employee_attendance` SET
  `Leave_Record_id` = 1,
  `Leave_req_id` = 9,
  `OT_Record_id` = 7,
  `attendance_record_id` = 5
WHERE `employee_Attendance_id` = 10;


-- skillset
UPDATE skillset SET emp_pnd_id = 6 WHERE skillset_id = 1;
UPDATE skillset SET emp_pnd_id = 7 WHERE skillset_id = 2;
UPDATE skillset SET emp_pnd_id = 8 WHERE skillset_id = 3;
UPDATE skillset SET emp_pnd_id = 9 WHERE skillset_id = 4;
UPDATE skillset SET emp_pnd_id = 10 WHERE skillset_id = 5;


-- employee_performance_and_development
UPDATE `employee_performance_and_development` SET
  `employee_promotion_id` = 2,
  `credit_score_grader_id` = 3
WHERE `emp_pnd_id` = 1;

UPDATE `employee_performance_and_development` SET
  `employee_promotion_id` = 5,
  `credit_score_grader_id` = 4
WHERE `emp_pnd_id` = 2;

UPDATE `employee_performance_and_development` SET
  `employee_promotion_id` = 8,
  `credit_score_grader_id` = 9
WHERE `emp_pnd_id` = 3;

UPDATE `employee_performance_and_development` SET
  `employee_promotion_id` = 1,
  `credit_score_grader_id` = 7
WHERE `emp_pnd_id` = 4;

UPDATE `employee_performance_and_development` SET
  `employee_promotion_id` = 10,
  `credit_score_grader_id` = 6
WHERE `emp_pnd_id` = 5;

UPDATE `employee_performance_and_development` SET
  `employee_promotion_id` = 3,
  `credit_score_grader_id` = 5
WHERE `emp_pnd_id` = 6;

UPDATE `employee_performance_and_development` SET
  `employee_promotion_id` = 6,
  `credit_score_grader_id` = 8
WHERE `emp_pnd_id` = 7;

UPDATE `employee_performance_and_development` SET
  `employee_promotion_id` = 9,
  `credit_score_grader_id` = 1
WHERE `emp_pnd_id` = 8;

UPDATE `employee_performance_and_development` SET
  `employee_promotion_id` = 4,
  `credit_score_grader_id` = 2
WHERE `emp_pnd_id` = 9;

UPDATE `employee_performance_and_development` SET
  `employee_promotion_id` = 7,
  `credit_score_grader_id` = 10
WHERE `emp_pnd_id` = 10;



