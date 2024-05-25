import React from "react";

export default function ProductDetails(props) {
    var images = [{chair:"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBHKE87lDevREYkRj-Jm5wl4clg5oL2l_Rv4NgX_V6_A&s"}]
    var src = ""
    return (
    <div>
      <div className="container">
        <div className="row">
          <div className="col-sm-12 col-md-3">
            {
                props.prod.pid===12?<img width={138} height={138} src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkKATBgoD6mwRjHBstzL4x-YpzAi0KUs8AVqFXZiT0Iw&s"></img>:src=""
            }
            {
            props.prod.pid===13?<img src="https://img.ofo.co.uk/media/img/shop/pm/103944.jpg" width={138} height={178}></img>:src=""
            }
            {
            props.prod.pid===14?<img width={138} height={138} src="https://media.gettyimages.com/id/165794808/vector/shelf.jpg?s=612x612&w=gi&k=20&c=gaCWt2DWHEGGSlNusVuJJkO2EvEaC24mUOy5HzGupT4="></img>:src=""
            }
            {
            props.prod.pid===15?<img width={138} height={178} src="https://mooreshomemakers.com.au/cdn/shop/products/narvik2.5sweb_1_600x.jpg?v=1611116113"></img>:src=""
            }   
        
          </div>
          <div className="col-sm-12 col-md-5">
            <span>
              {props.prod.pid}&nbsp;&nbsp;{props.prod.pname}{" "}
            </span>
          </div>
          <div className="col-sm-12 col-md-4">
            <span>
              {props.prod.qty}&nbsp;&nbsp;{props.prod.price}{" "}
            </span>
          </div>
        </div>
      </div>
    </div>
  );
}
