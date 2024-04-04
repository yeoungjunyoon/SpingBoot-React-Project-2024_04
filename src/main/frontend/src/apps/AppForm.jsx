import React, { useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [form, setForm] = useState({uid:'', uname:''});
  const handleChange = (event) => {
    const { name, value } = event.target;
    setForm({...form, [name]: value });
  }
  const handleSunmit = (e) => {
    e.preventDefault();
    const params = new URLSearchParams();
    params.append('uid', form.uid);
    params.append('uname', form.uid);
    console.log(params);
    axios
    .post('/rp/react/form', params)
    .then(res => {console.log(res);});

  }
  return (
    <div className="App">
    <form onSubmit={handleSunmit}>
      <label htmlFor="uid">아이디:</label>
      <input type='text' id='uid' name='id' value={form.uid} onChange={handleChange} /><br />
      <label htmlFor='name'>이름:</label>
      <button>확인</button>
    </form>
  </div>
  );
}

export default App;

