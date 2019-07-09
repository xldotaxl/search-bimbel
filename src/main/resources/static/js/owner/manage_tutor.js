const $tableTutor = $('#table-tutor');

function getActionButton(username) {
  return `<a href="#">View</a> | <a href="#">Delete</a>`;
}

const dataTableProp = {
  ajax: {
    dataSrc: json => {
      json.recordsTotal = json.length;
      json.recordsFiltered = json.length;
      return json;
    },
    url: `${tutorsApi}/${organizationIds}`,
  },
  columns: [
    {data: 'name'},
    {data: 'username'},
    {data: 'email'},
    {data: 'subjects'},
    {
      data: 'username',
      render: (data) => {
        return getActionButton(data);
      },
    },
  ],
  dom: 'ftipr',
  processing: true,
  searching: false,
  serverSide: true,
};

$(document).ready(() => {
  $tableTutor.DataTable(dataTableProp);
});
