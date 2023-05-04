import React, {useState} from 'react';
import axios from 'axios';

function App() {

  const [number, setNumber] = useState('');
  const [name, setName] = useState('');


  const numberChange = (e) => {
    setNumber(e.target.value);  
  }

  const nameChange = (e) => {
    setName(e.target.value);  
  }
  
 
  }

  const onSubmit = (e) => {
    // 이벤트 기본동작 취소하는 함수임.
    e.preventDefault();
    // alert('onSubmit');
    
    // file + form field => 짐을 싼다.
    let formData = new FormData();
    formData.append("number", number);
    formData.append("name", name);
    formData.append("uploadFile", document.frm.uploadFile.files[0]);

    // 보내자
    axios.post("http://localhost:3000/fileUpload", formData)
      .then(res=>{
        console.log(res.data);
        alert('file upload에 성공했습니다.');
      })
      .catch(function(error){
        alert('file upload에 실패했습니다.');
      });
    }

    // 다운로드
    const download = async () => {
      let fileName = "my.sql";
      const url = "http://localhost:3000/fileDownload?filename="+fileName;

      // a tag를 생성 + 자동 실행
      /*
      const download = document.createElement('a'); // <a></a>
      download.setAttribute('href', url);
      download.setAttribute('download', fileName);
      download.setAttribute('type', 'application/json');
      download.click();
      */

      // react에서는 window를 붙여야 한다.
      window.location.href = url;
    }


  return (
    <div>
      <h3>file upload</h3>
      <form name="frm" onSubmit={onSubmit} encType="multipart/form-data">
        <input value={number} onChange={numberChange} placeholder='번호'/>
        <br />
        <input value={name} onChange={nameChange} placeholder='이름'/>
        <br />
        <br />
        <input type="file" name="uploadFile" accept="*" />
        <input type="submit" value="file upload" />
      </form>

      <hr />
      <h3>file download</h3>
      <button onClick={download}>file download</button>



    </div>
  );
}

export default App;
