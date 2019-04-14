const logoutNav = 'logout-nav';
const logoutForm = 'logout-form';

function logoutComponentExists() {
  return document.getElementById(logoutNav) &&
    document.getElementById(logoutForm);
}

function registerLogoutListener() {
  const logoutAnchor = document.querySelector(`#${logoutNav}`);
  logoutAnchor.addEventListener('click', function(e) {
    e.preventDefault();
    document.getElementById(logoutForm).submit();
  });
}

function initLogoutEvent() {
  if (logoutComponentExists()) {
    registerLogoutListener();
  }
}

window.addEventListener('DOMContentLoaded', function() {
  initLogoutEvent();
});
