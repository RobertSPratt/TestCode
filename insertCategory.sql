/*
 * Prof. Tamerlano
 * IT 2351 Fall 2020
 * Robert Pratt
 * Assignment 6, No. 2
 */

USE RobertPrattGuitarShop;

DROP PROCEDURE IF EXISTS insertCategory;

DELIMITER ;;

CREATE PROCEDURE insertCategory
(
    category_name_param VARCHAR(50)
)
BEGIN
    DECLARE duplicate_category_name TINYINT DEFAULT FALSE;

    BEGIN
        DECLARE EXIT HANDLER FOR 1062
            SET duplicate_category_name = TRUE;

        IF(category_name_param IS NULL) THEN
            SIGNAL SQLSTATE '23000'
               SET MESSAGE_TEXT = 'Category must have a name.',
               MYSQL_ERRNO = 1048;
        END IF;

        INSERT INTO categories(category_id, category_name)
        VALUES(DEFAULT, 'Guitars');

        SELECT '1 row was inserted' AS message;
    END;

    IF(duplicate_category_name = TRUE) THEN
        SELECT 'Row was not inserted - duplicate entry.' AS message;
    END IF;
END;;

