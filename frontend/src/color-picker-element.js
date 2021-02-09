import {PolymerElement} from '@polymer/polymer/polymer-element.js';
import {html} from '@polymer/polymer/lib/utils/html-tag.js';

import '@polymer/paper-slider/paper-slider.js';
import '@polymer/paper-input/paper-input.js';

class ColorPickerElement extends PolymerElement {
  static get template() {
    return html`
    <style is="custom-style">

:root {
  --paper-custom-container-css: { --primary-text-color: var(--lumo-header-text-color);
                                                                         --paper-input-container-color=var(--lumo-header-text-color);
                                                                          width:5em;

                                                                         --paper-input-container-focus-color:var(--lumo-header-text-color);
                                                                         --paper-input-container-invalid-color:var(--lumo-header-text-color);
                                                                         --paper-input-container-input-color:var(--lumo-header-text-color);
}

}



      paper-slider.red {

--paper-slider-input:var(--paper-custom-container-css);
--paper-slider-input-container-input:var(--paper-custom-container-css);

        --paper-slider-knob-color: var(--paper-red-500);
        --paper-slider-active-color: var(--paper-red-500);
      }
      paper-slider.green {
      --paper-slider-input:var(--paper-custom-container-css);
      --paper-slider-input-container-input:var(--paper-custom-container-css);
        --paper-slider-knob-color: var(--paper-green-500);
        --paper-slider-active-color: var(--paper-green-500);
      }
      paper-slider.blue {
      --paper-slider-input:var(--paper-custom-container-css);
      --paper-slider-input-container-input:var(--paper-custom-container-css);
        --paper-slider-knob-color: var(--paper-light-blue-500);
        --paper-slider-active-color: var(--paper-light-blue-500);
      }
      paper-slider .slider-input {
          width: 50em;
          }
      divHeader{
         color: var(--lumo-header-text-color);
      }
      paper-input.input{

               .input-element{

               }
            }
      paper-input.custom{
   --primary-text-color: var(--lumo-header-text-color);
                                    width:15em;

//         margin-bottom: 14px;
//
//             --paper-input-container-color: black;
//             --paper-input-container-focus-color: black;
//             --paper-input-container-invalid-color: black;
//             border: 1px solid #BDBDBD;
//             border-radius: 5px;

             /* Reset some defaults */
             --paper-input-container: { padding: 0;};
             --paper-input-container-underline: { display: none; height: 0;};
             --paper-input-container-underline-focus: { display: none; };

             /* New custom styles */
             --paper-input-container-input: {
               box-sizing: border-box;
               font-size: inherit;
               padding: 4px;
             };
             --paper-input-container-input-focus: {
               background: rgba(0, 0, 0, 0.1);
             };
             --paper-input-container-input-invalid: {
               background: rgba(255, 0, 0, 0.3);
             };
         /*    --paper-input-container-label: {
               top: -8px;
               left: 4px;
               background: white;
               padding: 2px;
               font-weight: bold;
             };
             --paper-input-container-label-floating: {
               width: auto;
             };
*/
      }
}
rgbflexbox{
}
    </style>
    <div id="rgbflexbox" class"rgbflexbox" >
<div id="rgbcontanier" class"rgbcontanier" >
    <div id="divred" class="divHeader" >R</div>
    <paper-slider id="red" class="red" value="{{redColor}}" max="255" editable></paper-slider>
    <div id="divgreen"  class="divHeader" >G</div>
    <paper-slider id="green" class="green" value="{{greenColor}}" max="255" editable></paper-slider>
    <div id="divblue"  class="divHeader" >B</div>
    <paper-slider id="blue"class="blue" value="{{blueColor}}" max="255" editable></paper-slider>
    <paper-input id="grbColor" class="custom" value="{{grbColor}}"></paper-input>
</div>
    <div id="divColor" ></br> </br></div>
</div>
     `;
  }
}

customElements.define('color-picker-element', ColorPickerElement);