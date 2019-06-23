const $tableTutor = $('#table-tutor');

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
    { data: 'name' },
    { data: 'email' },
  ],
  dom: 'ftipr',
  processing: true,
  searching: false,
  serverSide: true,
};

$(document).ready(() => {
  $tableTutor.DataTable(dataTableProp);
});
