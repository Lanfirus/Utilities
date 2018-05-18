package ua.training.initializer;

/**
 * Holds statements to be used in utils/DBInitializator class to create/drop DBParameters with mock data
 */
public interface DBStatements {

    String CREATE_DB_STATEMENT = "CREATE SCHEMA IF NOT EXISTS time_tracking CHARACTER SET utf8 COLLATE utf8_general_ci";
    String DROP_DB_STATEMENT = "DROP SCHEMA IF EXISTS `time_tracking` ;";

    String CREATE_EMPLOYEE_TABLE_STATEMENT = "CREATE TABLE `employee` (" +
            "  `employee_id` INT NOT NULL AUTO_INCREMENT," +
            "  `employee_login` VARCHAR(45) NOT NULL," +
            "  `employee_password` VARCHAR(45) NOT NULL," +
            "  `employee_name` VARCHAR(45) NOT NULL," +
            "  `employee_surname` VARCHAR(45) NOT NULL," +
            "  `employee_patronymic` VARCHAR(45) NOT NULL DEFAULT ''," +
            "  `employee_email` VARCHAR(45) NOT NULL," +
            "  `employee_mobile_phone` VARCHAR(45) NOT NULL," +
            "  `employee_comment` VARCHAR(45) NOT NULL DEFAULT ''," +
            "  `employee_account_role` ENUM('admin', 'employee') NOT NULL DEFAULT 'employee'," +
            "  PRIMARY KEY (`employee_id`)," +
            "  UNIQUE INDEX `employee_id_UNIQUE` (`employee_id` ASC), " +
            "  UNIQUE INDEX `employee_login_UNIQUE` (`employee_login` ASC))" +
            "  ENGINE = InnoDB;";

    String CREATE_PROJECT_TABLE_STATEMENT = "CREATE TABLE `project` (" +
            "  `project_id` INT NOT NULL AUTO_INCREMENT," +
            "  `project_name` VARCHAR(45) NOT NULL, " +
            "  `project_deadline` DATE NOT NULL," +
            "  `project_status` ENUM('new', 'assigned', 'finished', 'cancelled') NOT NULL DEFAULT 'new'," +
            "  PRIMARY KEY  (`project_id`)," +
            "  UNIQUE INDEX `project_id_UNIQUE` (`project_id` ASC))" +
            "  ENGINE=InnoDB;";

    String CREATE_TASK_TABLE_STATEMENT = "CREATE TABLE `task` (" +
            "  `task_id` INT NOT NULL AUTO_INCREMENT," +
            "  `project_id` INT NOT NULL," +
            "  `employee_id` INT NOT NULL," +
            "  `task_name` VARCHAR(45) NOT NULL," +
            "  `task_status` ENUM('assigned', 'finished', 'cancelled') NOT NULL DEFAULT 'assigned'," +
            "  `task_deadline` DATE NULL," +
            "  `task_spent_time` INT NOT NULL DEFAULT 0," +
            "  `task_approval_state` ENUM('approved', 'not_approved', 'new_request') NOT NULL DEFAULT 'not_approved'," +
            "  PRIMARY KEY (`task_id`, `project_id`, `employee_id`)," +
            "  INDEX `fk_task_employee_idx` (`employee_id` ASC)," +
            "  INDEX `fk_task_project_idx` (`project_id` ASC)," +
            "  CONSTRAINT `fk_task_project`" +
            "  FOREIGN KEY (`project_id`)" +
            "  REFERENCES `project` (`project_id`)" +
            "  ON DELETE CASCADE" +
            "  ON UPDATE NO ACTION," +
            "  CONSTRAINT `fk_task_employee`" +
            "  FOREIGN KEY (`employee_id`)" +
            "  REFERENCES `employee` (`employee_id`)" +
            "  ON DELETE NO ACTION" +
            "  ON UPDATE NO ACTION," +
            "  UNIQUE INDEX `task_id_UNIQUE` (`task_id` ASC))" +
            "  ENGINE = InnoDB;";

    String INSERT_EMPLOYEE_RECORD_STATEMENT = "INSERT INTO `employee` (`employee_login`,`employee_password`," +
            "`employee_name`,`employee_surname`, `employee_patronymic`,`employee_email`,`employee_mobile_phone`," +
            "`employee_comment`,`employee_account_role`)";
    String INSERT_EMPLOYEE_RECORD1_VALUE = " VALUES ('aaa','47bce5c74f589f4867dbd57e9ca9f808','Petr','Petrov'," +
            "'Petrovich','petrovich@ua.ua','380501234567', 'Petrovich is the best!', 'admin');";
    String INSERT_EMPLOYEE_RECORD2_VALUE = " VALUES ('qqq','b2ca678b4c936f905fb82f2733f5297f','Ivan','Ivanov',''," +
            "'callToIvanych@i.ua','380661234567', 'just usual user', 'employee');";
    String INSERT_EMPLOYEE_RECORD3_VALUE = " VALUES ('111','698d51a19d8a121ce581499d7b701668','Maxim','Sidorov'," +
            "'Ivanovich','max@company.ua','380501234568', 'comment', 'employee');";

    String INSERT_PROJECT_RECORD_STATEMENT = "INSERT INTO `project` (`project_name`, `project_deadline`, " +
            "`project_status`)";
    String INSERT_PROJECT_RECORD1_VALUE = " VALUES ('Cassandra','20180530', 'assigned');";
    String INSERT_PROJECT_RECORD2_VALUE = " VALUES ('AX1267-2','20191222', 'assigned');";
    String INSERT_PROJECT_RECORD3_VALUE = " VALUES ('Project-X','20221012', 'assigned');";

    String INSERT_TASK_RECORD_STATEMENT = "INSERT INTO `task` (`project_id`,`employee_id`,`task_name`," +
            "  `task_status`,`task_deadline` , `task_spent_time`)";
    String INSERT_TASK_RECORD1_VALUE = " VALUES ('1', '1', 'Search for Cassandra', " +
            "   'assigned', '20180528', '10');";
    String INSERT_TASK_RECORD2_VALUE = " VALUES ('2', '2', 'AX1267-2-1'," +
            "   'assigned', '20191101', '2');";
    String INSERT_TASK_RECORD3_VALUE = " VALUES ('2', '2', 'AX1267-2-2'," +
            "   'assigned', 20180301, '0');";
    String INSERT_TASK_RECORD4_VALUE = " VALUES ('3', '3', 'XXX1'," +
            "   'assigned', null,'2');";
    String INSERT_TASK_RECORD5_VALUE = " VALUES ('3', '3', 'XXX2'," +
            "   'assigned', 20181105, '1');";

    String CREATE_TASK_DEADLINE_TRIGGER = "CREATE TRIGGER `task_BEFORE_INSERT` BEFORE INSERT ON `task` FOR EACH ROW begin\n" +
            "if new.task_deadline is null then\n" +
            "set new.task_deadline = (select project_deadline from project where project.project_id = new.project_id);\n" +
            "end if;\n" +
            "end";


    String CREATE_PROJECT_ARCHIVE_TABLE_STATEMENT = "CREATE TABLE `project_archive` (" +
            "  `project_id` INT NOT NULL," +
            "  `project_name` VARCHAR(45) NOT NULL, " +
            "  `project_deadline` DATE NOT NULL," +
            "  `project_status` ENUM('new', 'assigned', 'finished', 'cancelled') NOT NULL DEFAULT 'new'," +
            "  PRIMARY KEY  (`project_id`)," +
            "  UNIQUE INDEX `project_id_UNIQUE` (`project_id` ASC))" +
            "  ENGINE=InnoDB;";

    String CREATE_TASK_ARCHIVE_TABLE_STATEMENT = "CREATE TABLE `task_archive` (" +
            "  `task_id` INT NOT NULL," +
            "  `project_id` INT NOT NULL," +
            "  `employee_id` INT NOT NULL," +
            "  `task_name` VARCHAR(45) NOT NULL," +
            "  `task_status` ENUM('assigned', 'finished', 'cancelled') NOT NULL DEFAULT 'assigned'," +
            "  `task_deadline` DATE NULL," +
            "  `task_spent_time` INT NOT NULL DEFAULT 0," +
            "  `task_approval_state` ENUM('approved', 'not_approved', 'new_request') NOT NULL DEFAULT 'not_approved'," +
            "  PRIMARY KEY (`task_id`, `project_id`, `employee_id`)," +
            "  INDEX `fk_task_employee_idx` (`employee_id` ASC)," +
            "  INDEX `fk_task_project_idx` (`project_id` ASC)," +
            "  CONSTRAINT `fk_task_project_archive`" +
            "  FOREIGN KEY (`project_id`)" +
            "  REFERENCES `project_archive` (`project_id`)" +
            "  ON DELETE NO ACTION" +
            "  ON UPDATE NO ACTION," +
            "  CONSTRAINT `fk_task_employee2`" +
            "  FOREIGN KEY (`employee_id`)" +
            "  REFERENCES `employee` (`employee_id`)" +
            "  ON DELETE NO ACTION" +
            "  ON UPDATE NO ACTION," +
            "  UNIQUE INDEX `task_id_UNIQUE` (`task_id` ASC))" +
            "  ENGINE = InnoDB;";
}
