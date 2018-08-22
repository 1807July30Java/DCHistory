CREATE TABLE DC_CHARACTER(
    CHARACTER_ID INT PRIMARY KEY,
    CHARACTER_NAME VARCHAR2(100) UNIQUE,
    CHARACTER_AGE INT,
    CHARACTER_POWERS VARCHAR2(4000)
);
/

CREATE SEQUENCE SQ_DC_CHAR_PK
START WITH 1
INCREMENT BY 1;
/

--TRIGGERS
CREATE TRIGGER TR_DC_CHAR
BEFORE INSERT ON DC_CHARACTER
FOR EACH ROW
BEGIN
    SELECT SQ_DC_CHAR_PK.NEXTVAL INTO :NEW.CHARACTER_ID FROM DUAL;
END;
/