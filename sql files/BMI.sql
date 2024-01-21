--------------------------------------------------------
--  File created - Friday-December-09-2022   
--------------------------------------------------------
DROP TABLE "SYSTEM"."BMI";
--------------------------------------------------------
--  DDL for Table BMI
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."BMI" 
   (	"BMI_ID" VARCHAR2(10 BYTE), 
	"BMI_RANGE" VARCHAR2(50 BYTE), 
	"STATUS" VARCHAR2(50 BYTE), 
	"USER_ID" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.BMI
SET DEFINE OFF;
Insert into SYSTEM.BMI (BMI_ID,BMI_RANGE,STATUS,USER_ID) values ('1','<18.5','Underweight','5');
Insert into SYSTEM.BMI (BMI_ID,BMI_RANGE,STATUS,USER_ID) values ('2','18.5-24.9','Your BMI is Normal','3');
Insert into SYSTEM.BMI (BMI_ID,BMI_RANGE,STATUS,USER_ID) values ('3','25.0 - 29.9','Overweight','4');
Insert into SYSTEM.BMI (BMI_ID,BMI_RANGE,STATUS,USER_ID) values ('4','>=30','Obese','1');
Insert into SYSTEM.BMI (BMI_ID,BMI_RANGE,STATUS,USER_ID) values ('6','35.0 - 39.9','Obese class II','2');
Insert into SYSTEM.BMI (BMI_ID,BMI_RANGE,STATUS,USER_ID) values ('7','>=40','Obese class III','6');
--------------------------------------------------------
--  DDL for Index SYS_C008365
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C008365" ON "SYSTEM"."BMI" ("BMI_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table BMI
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."BMI" MODIFY ("BMI_RANGE" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."BMI" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."BMI" MODIFY ("USER_ID" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."BMI" ADD PRIMARY KEY ("BMI_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BMI
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."BMI" ADD CONSTRAINT "BMI_FK" FOREIGN KEY ("USER_ID")
	  REFERENCES "SYSTEM"."USERS" ("USER_ID") ENABLE;
