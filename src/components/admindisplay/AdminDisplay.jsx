import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useLocation } from 'react-router-dom';
import './Admin.css';

const AdminDisplay = () => {
  const location = useLocation();
  const adminRole = location.state ? location.state.adminRole : '';
  const [userData, setUserData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        setLoading(true);
        let response;

        if (adminRole === 'for author') {
          response = await axios.get(`http://localhost:8080/api/authors`);
        } else if (adminRole === 'for reader') {
          response = await axios.get(`http://localhost:8080/api/readers`);
        }

        if (response && response.data !== undefined && response.data !== null) {
          setUserData(response.data);
        } else {
          setError('No data found');
        }
      } catch (error) {
        console.error('Error fetching data:', error);
        setError('Error fetching data. Please try again.');
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, [adminRole]);

  const handleDelete = async (id) => {
    try {
      let deleteUrl;

      if (adminRole === 'for author') {
        const confirmDelete = window.confirm("Are you sure you want to delete this author?");
        if (!confirmDelete) {
          return; // Do nothing if user cancels the deletion
        }
        deleteUrl = `http://localhost:8080/api/author/${id}`;
      } else if (adminRole === 'for reader') {
        const confirmDelete = window.confirm("Are you sure you want to delete this reader?");
        if (!confirmDelete) {
          return; // Do nothing if user cancels the deletion
        }
        deleteUrl = `http://localhost:8080/api/reader/${id}`;
      }

      if (deleteUrl) {
        const response = await axios.delete(deleteUrl);
        // Handle success (e.g., show a success message, update the UI)
        console.log(response.data);
      } else {
        console.error('Invalid admin role');
      }
    } catch (error) {
      // Handle error (e.g., show an error message)
      console.error('Error deleting user:', error);
    }
  };

  let dashboardTitle;
  let userListTitle;
  if (adminRole === 'for author') {
    dashboardTitle = 'Author Dashboard';
    userListTitle = 'Author List';
  } else if (adminRole === 'for reader') {
    dashboardTitle = 'Reader Dashboard';
    userListTitle = 'Reader List';
  } 
  return (
    <>
    <div className="scroll-container">
      <h1>{dashboardTitle}</h1>
      <div className="user-list">
        <center>
          <h2>{userListTitle}</h2>
        </center>
        {loading ? (
          <p>Loading...</p>
        ) : error ? (
          <p>{error}</p>
        ) : (
          <table className="user-table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>ID</th>
                <th>Password</th>
                <th>Bio</th>
                <th>Gender</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {userData.map((user) => (
                <tr key={user.id}>
                  <td>{user.id}</td>
                  <td>{user.authorName || user.readerName}</td>
                  <td>{user.authorId || user.readerId}</td>
                  <td>{user.authorPassword || user.readerPassword}</td>
                  <td>{user.authorBio || ''}</td>
                  <td>{user.authorGender || user.readerGender}</td>
                  <td>
                    {adminRole === 'for author' && (
                      <button onClick={() => handleDelete(user.id)}>Delete Author</button>
                    )}
                    {adminRole === 'for reader' && (
                      <button onClick={() => handleDelete(user.id)}>Delete Reader</button>
                    )}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
      </div>
    </>
  );
};

export default AdminDisplay;
