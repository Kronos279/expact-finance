CREATE TABLE accounts (
      id UUID PRIMARY KEY,
      user_id VARCHAR(128) NOT NULL REFERENCES users(id) ON DELETE CASCADE,
      name VARCHAR(255) NOT NULL,
      account_type VARCHAR(50) NOT NULL,
      balance NUMERIC(20,8) NOT NULL,
      currency CHAR(3) NOT NULL,
      source VARCHAR(50) NOT NULL,
      source_ref VARCHAR(255),
      last_synced TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Index to speed up the NetWorthService queries
CREATE INDEX idx_accounts_user_id ON accounts(user_id);