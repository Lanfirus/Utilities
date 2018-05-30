package ua.training.initializer;

/**
 * Holds statements to be used in utils/DBInitializator class to create/drop DBParameters with mock data
 */
public interface DBStatements {

    String CREATE_DB_STATEMENT = "CREATE SCHEMA IF NOT EXISTS time_tracking CHARACTER SET utf8 COLLATE utf8_general_ci";
    String DROP_DB_STATEMENT = "DROP SCHEMA IF EXISTS `time_tracking` ;";

    String CREATE_EMPLOYEE_TABLE_STATEMENT = "CREATE TABLE `employee` (" +
            "  `employee_id` INT NOT NULL AUTO_INCREMENT," +
            "  `employee_login` VARCHAR(20) NOT NULL," +
            "  `employee_password` VARCHAR(32) NOT NULL," +
            "  `employee_name` VARCHAR(45) NOT NULL," +
            "  `employee_surname` VARCHAR(45) NOT NULL," +
            "  `employee_patronymic` VARCHAR(45) NOT NULL DEFAULT ''," +
            "  `employee_email` VARCHAR(319) NOT NULL," +
            "  `employee_mobile_phone` VARCHAR(13) NOT NULL," +
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
            "  `task_deadline` DATE NOT NULL," +
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
            "  ON DELETE CASCADE" +
            "  ON UPDATE NO ACTION," +
            "  UNIQUE INDEX `task_id_UNIQUE` (`task_id` ASC))" +
            "  ENGINE = InnoDB;";

    String INSERT_EMPLOYEE_RECORD_STATEMENT = "INSERT INTO `employee` (`employee_login`,`employee_password`," +
            "`employee_name`,`employee_surname`, `employee_patronymic`,`employee_email`,`employee_mobile_phone`," +
            "`employee_comment`,`employee_account_role`)";
    String INSERT_EMPLOYEE_RECORD1_VALUE = " VALUES ('Petr111','47bce5c74f589f4867dbd57e9ca9f808','Petr','Petrov'," +
            "'Petrovich','ppetrov@ua.ua','380501234567', 'Petrovich is the best admin!', 'admin');";
    String INSERT_EMPLOYEE_RECORD2_VALUE = " VALUES ('ivanivanov','b2ca678b4c936f905fb82f2733f5297f','Ivan','Ivanov',''," +
            "'callToIvanych@i.ua','380661234567', 'just usual user', 'employee');";
    String INSERT_EMPLOYEE_RECORD3_VALUE = " VALUES ('maxim555','698d51a19d8a121ce581499d7b701668','Maxim','Sidorov'," +
            "'Ivanovich','max@company.ua','380501234568', '', 'employee');";
    String INSERT_EMPLOYEE_RECORD4_VALUE = " VALUES ('dunayskiy1','698d51a19d8a121ce581499d7b701668','Alexander','Dunayskiy'," +
            "'','alexd@company.ua','380991234568', '', 'employee');";
    String INSERT_EMPLOYEE_RECORD5_VALUE = " VALUES ('sidorov_f','698d51a19d8a121ce581499d7b701668','Felix','Sidorov'," +
            "'Maksimovich','hr@company.ua','380661234568', 'our HR', 'employee');";
    String INSERT_EMPLOYEE_RECORD6_VALUE = " VALUES ('zalexey','698d51a19d8a121ce581499d7b701668','Alexey','Zodin'," +
            "'','zodin@company.ua','380671234568', '', 'employee');";

    String INSERT_PROJECT_RECORD_STATEMENT = "INSERT INTO `project` (`project_name`, `project_deadline`, " +
            "`project_status`)";
    String INSERT_PROJECT_RECORD1_VALUE = " VALUES ('Cassandra','20180630', 'assigned');";
    String INSERT_PROJECT_RECORD2_VALUE = " VALUES ('AX1267-2','20191222', 'assigned');";
    String INSERT_PROJECT_RECORD3_VALUE = " VALUES ('Project-X','20221012', 'assigned');";
    String INSERT_PROJECT_RECORD4_VALUE = " VALUES ('Проект Мрія','20180830', 'finished');";
    String INSERT_PROJECT_RECORD5_VALUE = " VALUES ('42','20190122', 'new');";
    String INSERT_PROJECT_RECORD6_VALUE = " VALUES ('Fly to Mars','20211012', 'cancelled');";

    String INSERT_TASK_RECORD_STATEMENT = "INSERT INTO `task` (`project_id`,`employee_id`,`task_name`," +
            "  `task_status`,`task_deadline` , `task_spent_time`)";
    String INSERT_TASK_RECORD1_VALUE = " VALUES ('1', '2', 'Search for Cassandra', " +
            "   'assigned', '20180628', '10');";
    String INSERT_TASK_RECORD2_VALUE = " VALUES ('2', '2', 'AX1267-2-1'," +
            "   'assigned', '20191101', '2');";
    String INSERT_TASK_RECORD3_VALUE = " VALUES ('2', '2', 'AX1267-2-2'," +
            "   'cancelled', 20180301, '0');";
    String INSERT_TASK_RECORD4_VALUE = " VALUES ('3', '3', 'XXX1'," +
            "   'assigned', 20181105,'2');";
    String INSERT_TASK_RECORD5_VALUE = " VALUES ('3', '3', 'XXX2'," +
            "   'assigned', 20181105, '1');";
    String INSERT_TASK_RECORD6_VALUE = " VALUES ('4', '4', 'Розробка документації', " +
            "   'finished', '20180528', '10');";
    String INSERT_TASK_RECORD7_VALUE = " VALUES ('4', '5', 'Вироблення зразка'," +
            "   'finished', '20180701', '26');";
    String INSERT_TASK_RECORD8_VALUE = " VALUES ('4', '6', 'Випробовування'," +
            "   'finished', 20180822, '33');";
    String INSERT_TASK_RECORD9_VALUE = " VALUES ('1', '3', 'Reach Cassandra'," +
            "   'assigned', 20180628,'32');";
    String INSERT_TASK_RECORD10_VALUE = " VALUES ('2', '3', 'AX1267-2-3'," +
            "   'assigned', 20180801, '14');";
    String INSERT_TASK_RECORD11_VALUE = " VALUES ('3', '4', 'XXX3', " +
            "   'assigned', '20200528', '10');";
    String INSERT_TASK_RECORD12_VALUE = " VALUES ('6', '2', 'FTM-1'," +
            "   'cancelled', '20191101', '2');";
    String INSERT_TASK_RECORD13_VALUE = " VALUES ('6', '2', 'FTM-2'," +
            "   'cancelled', 20180301, '0');";
    String INSERT_TASK_RECORD14_VALUE = " VALUES ('6', '5', 'FTM-3'," +
            "   'cancelled', 20190301,'2');";
    String INSERT_TASK_RECORD15_VALUE = " VALUES ('6', '6', 'FTM-4'," +
            "   'cancelled', 20181105, '1');";

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
            "  `task_deadline` DATE NOT NULL," +
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
