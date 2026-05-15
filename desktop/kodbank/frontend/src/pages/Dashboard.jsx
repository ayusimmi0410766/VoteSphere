import { useState } from 'react';
import confetti from 'canvas-confetti';
import { API_ENDPOINTS } from '../api/config';
import './Dashboard.css';

export default function Dashboard() {
  const [balance, setBalance] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');
  const [showCelebration, setShowCelebration] = useState(false);

  const triggerPartyPopper = () => {
    const duration = 2500;
    const end = Date.now() + duration;

    const frame = () => {
      confetti({
        particleCount: 5,
        angle: 60,
        spread: 55,
        origin: { x: 0 },
        colors: ['#d4af37', '#00c853', '#7c3aed', '#ff6b6b', '#4ecdc4'],
      });
      confetti({
        particleCount: 5,
        angle: 120,
        spread: 55,
        origin: { x: 1 },
        colors: ['#d4af37', '#00c853', '#7c3aed', '#ff6b6b', '#4ecdc4'],
      });

      if (Date.now() < end) {
        requestAnimationFrame(frame);
      }
    };
    frame();

    setTimeout(() => {
      confetti({
        particleCount: 100,
        spread: 100,
        origin: { y: 0.6 },
        colors: ['#d4af37', '#00c853', '#7c3aed'],
      });
    }, 200);
  };

  const handleCheckBalance = async () => {
    setError('');
    setBalance(null);
    setShowCelebration(false);
    setLoading(true);
    try {
      const res = await fetch(API_ENDPOINTS.balance, {
        credentials: 'include',
      });
      const data = await res.json();
      console.log('Balance response:', data);
      if (!res.ok) throw new Error(data.error || 'Failed to fetch balance');
      setBalance(data.balance);
      setShowCelebration(true);
      triggerPartyPopper();
    } catch (err) {
      console.error('Balance error:', err);
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className={`dashboard-page ${showCelebration ? 'celebration-bg' : ''}`}>
      <div className="dashboard-card">
        <h1 className="dashboard-title">Kodbank Dashboard</h1>
        <p className="dashboard-welcome">Welcome to your account</p>

        <button
          onClick={handleCheckBalance}
          disabled={loading}
          className="btn-balance"
        >
          {loading ? 'Loading...' : 'Check Balance'}
        </button>

        {error && <p className="error-msg">{error}</p>}

        {balance !== null && (
          <div className="balance-result">
            <p className="balance-message">Your balance is: ₹{balance.toLocaleString()}</p>
          </div>
        )}
      </div>
    </div>
  );
}
