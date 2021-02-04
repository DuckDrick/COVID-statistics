import axios from 'axios'
import React, { useEffect, useState } from 'react'
import LineChart from './features/chart/LineChart';
import ChoiceBox from './features/choice box/ChoiceBox';


const App = () => {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [countries, setCountries] = useState(null);
  const [country, setCountry] = useState(null);

  const handleChange = e => setCountry(e.value.country);
  
  useEffect(() => {
    axios.get('/covid/countries')
    .then(result => setCountries(result.data))
    .catch(_ => setError("Failed to fetch country list"));
  }, [])

  useEffect(() => {
    if(country) {
      setLoading(true);
      setError('')
      axios.get('/covid', {
        params: {
          country: country
        }
      }).then(result => setData(result.data))
      .catch(_ => setError("Failed to fetch data"))
      .finally(_ => setLoading(false));
    }
  }, [country]);
  
  return (
    <>
      {countries && <ChoiceBox countries={countries} onChange={handleChange}/>}
      {error}
      {!country ? <p>Please select a country</p> :
        loading ? <p>Loading...</p> : 
         <LineChart data={data} />
      }
    </>
  );
}

export default App;
