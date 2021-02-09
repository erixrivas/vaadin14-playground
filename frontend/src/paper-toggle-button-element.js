import {PolymerElement} from '@polymer/polymer/polymer-element.js';
import {html} from '@polymer/polymer/lib/utils/html-tag.js';

import '@polymer/paper-toggle-button/paper-toggle-button.js';

class PaperToggleButtonElement extends PolymerElement {
  static get template() {
    return html`
      <paper-toggle-button id="papertogglebutton" on-click="change" on-change="toggleShow" on-track="toggleShow" checked></paper-toggle-button>

    `;
  }
}

customElements.define('paper-toggle-button-element', PaperToggleButtonElement);