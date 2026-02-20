/**
 * Kodbank API Configuration
 * Connects to the deployed backend
 */
export const API_BASE_URL = 'https://kodbank-backend-31fm.onrender.com/api';

/**
 * Default fetch options for API calls (includes credentials for cookie-based auth)
 */
export const DEFAULT_FETCH_OPTIONS = {
  credentials: 'include',
  headers: {
    'Content-Type': 'application/json',
  },
};

/**
 * API endpoints
 */
export const API_ENDPOINTS = {
  register: `${API_BASE_URL}/register`,
  login: `${API_BASE_URL}/login`,
  balance: `${API_BASE_URL}/balance`,
};
