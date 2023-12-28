import React, { useState } from 'react';
import axios from 'axios';
import { toast, ToastContainer } from 'react-toastify';
import { useNavigate } from 'react-router-dom';
import 'react-toastify/dist/ReactToastify.css';
import './Styles1.css';

const AdminLogin = () => {
  const [adminName, setAdminName] = useState('');
  const [adminId, setAdminId] = useState('');
  const [adminPassword, setAdminPassword] = useState('');
  const [adminRole, setAdminRole] = useState('');

  const navigate = useNavigate();

  const handleLogin = async () => {
    try {
      const response = await axios.post(`http://localhost:8080/login/admin`, {
        adminId,
        adminPassword,
        adminRole,
        adminName,
      });

      if (response.data === 'Admin login successful') {
        toast.success('Admin login successful');
        
        // Use navigate function to navigate programmatically
        navigate('/admin-display', { state: { adminRole } }); // Pass adminRole as state
      } else {
        toast.error('Invalid admin credentials',{
          position:'top-left',
          autoClose:2000,
          hideProgressBar:false,
          closeOnClick:true,
          style:{
            fontSize:'16px',
            padding:'16px',
            whiteSpace:'nowrap'},
          });
      }
    } catch (error) {
      console.error('Error during admin login:', error);
      if (error.response && error.response.status === 401) {
        toast.error('Invalid admin credentials',{
          position:'top-left',
          autoClose:2000,
          hideProgressBar:false,
          closeOnClick:true,
          style:{
            fontSize:'16px',
            padding:'16px',
            whiteSpace:'nowrap'},
          });
      } else {
        toast.error('Error during login');
      }
    }
  };

  return (
    <div className="admin-login-container">
      <h2>Admin Login</h2>
      <ToastContainer />
      <form>
        <label htmlFor="adminName">Name:</label>
        <input
          type="text"
          id="adminName"
          value={adminName}
          onChange={(e) => setAdminName(e.target.value)}
        />
        <label htmlFor="adminId">Admin ID:</label>
        <input
          type="text"
          id="adminId"
          value={adminId}
          onChange={(e) => setAdminId(e.target.value)}
        />
        <label htmlFor="adminPassword">Password:</label>
        <input
          type="password"
          id="adminPassword"
          value={adminPassword}
          onChange={(e) => setAdminPassword(e.target.value)}
        />
        <label htmlFor="adminRole">Role:</label>
        <input
          type="text"
          id="adminRole"
          value={adminRole}
          onChange={(e) => setAdminRole(e.target.value)}
        />

        <button type="button" onClick={handleLogin}>
          Login
        </button>
      </form>
    </div>
  );
};

export default AdminLogin;
