CREATE TABLE loans (
   id UUID PRIMARY KEY,
   user_id VARCHAR(128) NOT NULL REFERENCES users(id) ON DELETE CASCADE,
   name VARCHAR(255) NOT NULL,
   principal NUMERIC(20,8) NOT NULL,
   currency CHAR(3) NOT NULL REFERENCES reference_rates(currency_code),
   rate_type VARCHAR(50) NOT NULL,
   current_rate NUMERIC(5,2) NOT NULL,
   spread NUMERIC(5,2) NOT NULL,
   emi_amount NUMERIC(20,8) NOT NULL,
   emi_currency CHAR(3) NOT NULL
);

CREATE INDEX idx_loans_user_id ON loans(user_id);