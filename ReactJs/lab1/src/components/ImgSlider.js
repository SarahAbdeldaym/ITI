import { Component } from 'react';
import "./imgSlider.css"

export default class imgSlider extends Component {

    constructor() {
        super();
        this.state = {
            imgNum: 1,
            imgSrc: "./imgs/1.png",
            interval: 0,
          
        }
    }

    nextBtn = () => {
        if (this.state.imgNum < 4) {
            this.state.imgNum++;
            this.setState({ imgNum: this.state.imgNum });
            this.setState({ imgSrc: `./imgs/${this.state.imgNum}.png` })
        }
    }

    previousBtn = () => {
        if (this.state.imgNum <= 1) {
            this.state.imgNum = 1;
        } else {
            this.state.imgNum--;
            this.setState({ imgNum: this.state.imgNum });
            this.setState({ imgSrc: `./imgs/${this.state.imgNum}.png` })
        }
    }


    start = () => {

        this.state.interval = setInterval(() => {
            if (this.state.imgNum >= 4) {
                this.state.imgNum = 1;
            }
            else {
                this.state.imgNum++;
               
            }
            this.setState({ imgNum: this.state.imgNum });
            this.setState({ imgSrc: `./imgs/${this.state.imgNum}.png` })
        }, 1000);
    }

    stop = () => {
        clearInterval(this.state.interval);
    }


    render() {
        return (
            <div align="center">

                <h1>My Slide Bar &hearts;</h1>
                <img src={this.state.imgSrc} className="imgSlider" />

                <br />
                {this.state.imgNum}
                <br />

                <input
                    type="button"
                    value="<<"
                    onClick={this.previousBtn}
                />


                <input
                    type="button"
                    value="Slide"
                    onClick={this.start}
                />

                <input
                    type="button"
                    value="Stop"
                    onClick={this.stop}
                />

                <input
                    type="button"
                    value=">>"
                    onClick={this.nextBtn}
                />

            </div>
        )
    }

}