import React, { Component } from 'react';
import Titles from './components/Titles';
import Form from './components/Form';
import Weather from './components/Weather';

import axios from 'axios';

//e8a657ec3a36fb4d13b1a0f6d323ed13 = API KEY
const API_KEY = 'e8a657ec3a36fb4d13b1a0f6d323ed13';
class App extends Component {
  state = {
    city: undefined,
    country: undefined,
    temperture: undefined,
    humidity: undefined,
    discription: undefined,
    error: undefined
  }

  getWeather = async (e) => {
    e.preventDefault();
    const city = e.target.elements.city.value;
    const country = e.target.elements.country.value;

    console.log("HERE");
    const apiCall = axios.get(`http://localhost:9999/weather/${city}/${country}`).then(response => {
      console.log(response);
      if (city && country) {
    
          this.setState({
            temperature: response.data.temperature,
            city: response.data.city,
            country: response.data.country,
            humidity: response.data.humidity,
            discription: response.data.description,
            error: ''
          });
        }
    });
  }

  render() {
    return (
      <div>
        <div className="wrapper">
          <div className="main">
            <div className="container">
              <div className="row">
                <div className="col-xs-5 title-container">
                  <Titles />
                </div>
                <div className="col-xs-7 form-container">
                  <Form getWeather={this.getWeather} />
                  <Weather temperature={this.state.temperature}
                    city={this.state.city}
                    country={this.state.country}
                    humidity={this.state.humidity}
                    discription={this.state.discription}
                    error={this.state.error}
                  />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>);
  }
};

export default App;