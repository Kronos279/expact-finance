CREATE TABLE recurring_payments (
    id UUID PRIMARY KEY,
    user_id VARCHAR(128) NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    name VARCHAR(255) NOT NULL,
    amount NUMERIC(20,8) NOT NULL,
    currency CHAR(3) NOT NULL,
    frequency VARCHAR(50) NOT NULL
);

CREATE INDEX idx_recurring_payments_user_id ON recurring_payments(user_id);