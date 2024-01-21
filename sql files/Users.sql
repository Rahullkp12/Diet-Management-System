--------------------------------------------------------
--  File created - Friday-December-09-2022   
--------------------------------------------------------
DROP TABLE "SYSTEM"."USERS";
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."USERS" 
   (	"USER_ID" VARCHAR2(10 BYTE), 
	"FIRST_NAME" VARCHAR2(20 BYTE), 
	"LAST_NAME" VARCHAR2(20 BYTE), 
	"EMAIL" VARCHAR2(50 BYTE), 
	"PASSWORD" VARCHAR2(30 BYTE), 
	"GENDER" VARCHAR2(20 BYTE), 
	"USER_HEIGHT" VARCHAR2(20 BYTE), 
	"USER_WEIGHT" VARCHAR2(20 BYTE), 
	"N_ID" VARCHAR2(20 BYTE), 
	"USER_BMI" FLOAT(126) GENERATED ALWAYS AS (ROUND(TO_NUMBER("USER_WEIGHT")/(TO_NUMBER("USER_HEIGHT")*TO_NUMBER("USER_HEIGHT")),4)) VIRTUAL 
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.USERS
SET DEFINE OFF;
Insert into SYSTEM.USERS (USER_ID,FIRST_NAME,LAST_NAME,EMAIL,PASSWORD,GENDER,USER_HEIGHT,USER_WEIGHT,N_ID,USER_BMI) values ('1','Joe','Schuler','Joe@gmail.com','Joe11','Male','1.43','74','2',36.1876);
Insert into SYSTEM.USERS (USER_ID,FIRST_NAME,LAST_NAME,EMAIL,PASSWORD,GENDER,USER_HEIGHT,USER_WEIGHT,N_ID,USER_BMI) values ('2','Jim','Phillis','Jim@gmail.com','Jim12','Male','1.64','100','3',37.1802);
Insert into SYSTEM.USERS (USER_ID,FIRST_NAME,LAST_NAME,EMAIL,PASSWORD,GENDER,USER_HEIGHT,USER_WEIGHT,N_ID,USER_BMI) values ('3','Vanessa','Gwinn','Vanessa@gmail.com','Vanessa13','Female','1.52','48','5',20.7756);
Insert into SYSTEM.USERS (USER_ID,FIRST_NAME,LAST_NAME,EMAIL,PASSWORD,GENDER,USER_HEIGHT,USER_WEIGHT,N_ID,USER_BMI) values ('4','Annie','Oboyle','Annie@gmail.com','Annie14','Female','1.58','90','1',36.0519);
Insert into SYSTEM.USERS (USER_ID,FIRST_NAME,LAST_NAME,EMAIL,PASSWORD,GENDER,USER_HEIGHT,USER_WEIGHT,N_ID,USER_BMI) values ('5','Jack','Croteau','Jack@gmail.com','Jack15','Male','1.49','85','4',38.2866);
Insert into SYSTEM.USERS (USER_ID,FIRST_NAME,LAST_NAME,EMAIL,PASSWORD,GENDER,USER_HEIGHT,USER_WEIGHT,N_ID,USER_BMI) values ('6','Allie','Giorgio','Allie@gmail.com','Allie16','Female','1.67','150','2',53.7846);
Insert into SYSTEM.USERS (USER_ID,FIRST_NAME,LAST_NAME,EMAIL,PASSWORD,GENDER,USER_HEIGHT,USER_WEIGHT,N_ID,USER_BMI) values ('7','Anthony','Revis','Anthony@gmail.com','Anthony17','Male','1.61','65','5',25.0762);
--------------------------------------------------------
--  DDL for Index SYS_C008354
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C008354" ON "SYSTEM"."USERS" ("USER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."USERS" MODIFY ("FIRST_NAME" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."USERS" MODIFY ("LAST_NAME" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."USERS" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."USERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."USERS" MODIFY ("GENDER" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."USERS" MODIFY ("USER_HEIGHT" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."USERS" MODIFY ("USER_WEIGHT" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."USERS" MODIFY ("N_ID" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."USERS" ADD PRIMARY KEY ("USER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."USERS" ADD CONSTRAINT "USERS_FK" FOREIGN KEY ("N_ID")
	  REFERENCES "SYSTEM"."NUTRITIONIST" ("N_ID") ENABLE;