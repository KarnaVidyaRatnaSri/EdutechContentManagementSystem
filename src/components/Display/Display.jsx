import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUser, faPencilAlt, faEye } from '@fortawesome/free-solid-svg-icons';
import { Link } from 'react-router-dom';
import './Display.css';

const Display = () => {
  return (
    <div>
      <h1>EDUTECH CONTENT MANAGEMENT SYSTEM</h1>
      <div className="user-icons">
        <div>
          <Link to="/admin-login">
            <FontAwesomeIcon icon={faUser} size="5x" />
            <p>Admin</p>
          </Link>
        </div>
        <div>
          <Link to="/author-login">
            <FontAwesomeIcon icon={faPencilAlt} size="5x" />
            <p>Author</p>
          </Link>
        </div>
        <div>
          <Link to="/reader-login">
            <FontAwesomeIcon icon={faEye} size="5x" />
            <p>Reader</p>
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Display;
