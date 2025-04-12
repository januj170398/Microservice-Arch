INSERT INTO customer (customer_id, name, email, mobile_number, created_at, created_by)
VALUES (1, 'Test User', 'test@example.com', '4354437687', CURRENT_TIMESTAMP, 'InitialSetup');

INSERT INTO accounts (customer_id, account_number, account_type, branch_address, created_at, created_by)
VALUES (1, 1234567890, 'SAVINGS', '123 Test Street', CURRENT_TIMESTAMP, 'InitialSetup');
